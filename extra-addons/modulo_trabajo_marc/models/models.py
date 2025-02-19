# -*- coding: utf-8 -*-

from odoo import models, fields, api
from odoo.exceptions import ValidationError


class Comisaria(models.Model):
    _name = 'modulo_trabajo_marc.comisaria'
    _description = 'Comisarías'

    name = fields.Char(string='Nombre', required=True)
    direccion = fields.Text(string='Dirección')
    telefono = fields.Char(string='Teléfono')
    agente_ids = fields.One2many('modulo_trabajo_marc.agente', 'comisaria_id', string='Agentes Asignados')

class Rango(models.Model):
    _name = 'modulo_trabajo_marc.rango'
    _description = 'Rangos policiales'
    _order = 'nivel desc'

    name = fields.Selection([
        ('capitan', 'Capitán'),
        ('teniente', 'Teniente'),
        ('detective_iii', 'Detective III'),
        ('sargento_ii', 'Sargento II'),
        ('detective_ii', 'Detective II'),
        ('sargento_i', 'Sargento I'),
        ('detective_i', 'Detective I'),
        ('oficial_iii', 'Oficial III'),
        ('oficial_ii', 'Oficial II'),
        ('oficial_i', 'Oficial I'),
        ('oficial_practicas', 'Oficial en prácticas'),
    ], string='Rango', required=True)
    nivel = fields.Integer(string='Nivel Jerárquico', compute='_compute_nivel', store=True)

    @api.depends('name')
    def _compute_nivel(self):
        rangos_nivel = {
            'capitan': 11,
            'teniente': 10,
            'detective_iii': 9,
            'sargento_ii': 8,
            'detective_ii': 7,
            'sargento_i': 6,
            'detective_i': 5,
            'oficial_iii': 4,
            'oficial_ii': 3,
            'oficial_i': 2,
            'oficial_practicas': 1,
        }
        for rango in self:
            rango.nivel = rangos_nivel.get(rango.name, 0)

class Division(models.Model):
    _name = 'modulo_trabajo_marc.division'
    _description = 'Divisiones policiales'

    name = fields.Selection([
        ('relaciones_publicas', 'Relaciones Públicas'),
        ('robos_homicidios', 'Robos y Homicidios'),
        ('delitos_graves', 'Delitos Graves'),
        ('delitos_violencia', 'Delitos con Violencia'),
        ('narcoticos', 'Narcóticos'),
        ('swat', 'S.W.A.T'),
        ('air_support', 'Air Support Division'),
        ('corrections', 'Department of Corrections'),
        ('justice', 'Department of Justice'),
        ('trafico', 'Tráfico'),
        ('asuntos_internos', 'Asuntos Internos'),
        ('forestales', 'Forestales'),
    ], string='División', required=True)
    descripcion = fields.Text(string='Descripción')

class AgenteDivision(models.Model):
    _name = 'modulo_trabajo_marc.agente_division'
    _description = 'Relación Agente-División'

    agente_id = fields.Many2one('modulo_trabajo_marc.agente', string='Agente', required=True)
    division_id = fields.Many2one('modulo_trabajo_marc.division', string='División', required=True)
    rango_division = fields.Selection([
        ('jefe', 'Jefe de División'),
        ('subjefe', 'Subjefe'),
        ('supervisor', 'Supervisor'),
        ('investigador', 'Investigador'),
        ('agente', 'Agente'),
    ], string='Rango en División', required=True)