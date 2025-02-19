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