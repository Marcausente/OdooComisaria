# -*- coding: utf-8 -*-

from odoo import models, fields, api, _
from odoo.exceptions import ValidationError


class Comisaria(models.Model):
    _name = 'modulo_trabajo_marc.comisaria'
    _description = 'Comisarías'
    _inherit = ['mail.thread', 'mail.activity.mixin']

    name = fields.Char(string='Nombre de la Comisaría', required=True, tracking=True)
    direccion = fields.Char(string='Dirección', tracking=True)
    telefono = fields.Char(string='Teléfono', tracking=True)
    
    # Relación con los agentes
    agente_ids = fields.One2many('modulo_trabajo_marc.agente', 'comisaria_id', string='Agentes asignados')
    
    # Estadísticas
    agentes_count = fields.Integer(string='Número de agentes', compute='_compute_agentes_count')
    
    @api.depends('agente_ids')
    def _compute_agentes_count(self):
        for comisaria in self:
            comisaria.agentes_count = len(comisaria.agente_ids)

    def action_view_agentes(self):
        self.ensure_one()
        return {
            'name': 'Agentes de ' + self.name,
            'view_mode': 'list,form',
            'res_model': 'modulo_trabajo_marc.agente',
            'domain': [('comisaria_id', '=', self.id)],
            'type': 'ir.actions.act_window',
            'context': {'default_comisaria_id': self.id, 'create': False}
        }

class Rango(models.Model):
    _name = 'modulo_trabajo_marc.rango'
    _description = 'Rangos policiales'
    _order = 'sequence'

    name = fields.Char(string='Nombre del Rango', required=True)
    codigo = fields.Char(string='Código interno', required=True)
    sequence = fields.Integer(string='Secuencia', default=10, 
                             help='Determina el orden de los rangos. Los números más bajos aparecen primero.')

    # Relación inversa con Agentes
    agente_ids = fields.One2many('modulo_trabajo_marc.agente', 'rango_id', string='Agentes con este rango')

    def name_get(self):
        result = []
        for rango in self:
            result.append((rango.id, rango.name))
        return result

class Division(models.Model):
    _name = 'modulo_trabajo_marc.division'
    _description = 'Divisiones policiales'
    _inherit = ['mail.thread', 'mail.activity.mixin']

    name = fields.Char(string='Nombre división', required=True)
    descripcion = fields.Text(string='Descripción')
    
    # Relación con agentes
    agente_ids = fields.Many2many(
        'modulo_trabajo_marc.agente',
        'agente_division_rel',
        'division_id',
        'agente_id',
        string='Agentes asignados')
        
    # Para seguimiento de rangos específicos en cada división
    agente_division_ids = fields.One2many('modulo_trabajo_marc.agente_division', 'division_id', string='Rangos en división')

class AgenteDivision(models.Model):
    _name = 'modulo_trabajo_marc.agente_division'
    _description = 'Rango en división específica'
    
    agente_id = fields.Many2one('modulo_trabajo_marc.agente', string='Agente', required=True, ondelete='cascade')
    division_id = fields.Many2one('modulo_trabajo_marc.division', string='División', required=True, ondelete='cascade')
    rango_division = fields.Char(string='Rango en la división')
    
    _sql_constraints = [
        ('agente_division_uniq', 'unique(agente_id, division_id)', 'El agente ya tiene un registro en esta división!')
    ]

class Arma(models.Model):
    _name = 'modulo_trabajo_marc.arma'
    _description = 'Registro de armas'
    _inherit = ['mail.thread', 'mail.activity.mixin']

    name = fields.Char(string='Nombre/Modelo', required=True)
    numero_serie = fields.Char(string='Número de serie', required=True, tracking=True)
    tipo = fields.Selection([
        ('pistola', 'Pistola'),
        ('rifle', 'Rifle'),
        ('escopeta', 'Escopeta'),
        ('otro', 'Otro')
    ], string='Tipo de arma', default='pistola', required=True, tracking=True)
    
    agente_id = fields.Many2one('modulo_trabajo_marc.agente', string='Asignada a', tracking=True, ondelete='restrict')
    
    _sql_constraints = [
        ('serie_uniq', 'unique(numero_serie)', 'El número de serie del arma debe ser único!')
    ]

class Agente(models.Model):
    _name = 'modulo_trabajo_marc.agente'
    _description = 'Agentes de policía'
    _inherit = ['mail.thread', 'mail.activity.mixin']

    name = fields.Char(string='Nombre Completo', required=True, tracking=True)
    numero_placa = fields.Char(string='Número de Placa', required=True, size=3, tracking=True)
    
    # Relaciones
    comisaria_id = fields.Many2one('modulo_trabajo_marc.comisaria', string='Comisaría asignada', 
                                  required=True, tracking=True, ondelete='restrict')
    rango_id = fields.Many2one('modulo_trabajo_marc.rango', string='Rango', 
                              required=True, tracking=True, ondelete='restrict')
    
    # Relación con armas
    arma_ids = fields.One2many('modulo_trabajo_marc.arma', 'agente_id', string='Armas asignadas')
    
    # Divisiones
    division_ids = fields.Many2many(
        'modulo_trabajo_marc.division',
        'agente_division_rel',
        'agente_id',
        'division_id',
        string='Divisiones asignadas')
        
    _sql_constraints = [
        ('placa_uniq', 'unique(numero_placa)', 'El número de placa debe ser único!')
    ]
    
    @api.constrains('numero_placa')
    def _check_numero_placa(self):
        for record in self:
            if not record.numero_placa.isdigit() or len(record.numero_placa) != 3:
                raise ValidationError(_("El número de placa debe contener exactamente 3 dígitos."))