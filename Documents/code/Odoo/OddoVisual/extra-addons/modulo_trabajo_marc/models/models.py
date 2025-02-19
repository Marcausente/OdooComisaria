# -*- coding: utf-8 -*-

from odoo import models, fields, api

class ModuloTrabajoMarc(models.Model):
    _name = 'modulo_trabajo_marc.modulo_trabajo_marc'
    _description = 'Módulo Trabajo Marc'

    name = fields.Char(string='Nombre', required=True)
    value = fields.Integer(string='Valor')
    description = fields.Text(string='Descripción')

#     value2 = fields.Float(compute="_value_pc", store=True)
#
#     @api.depends('value')
#     def _value_pc(self):
#         for record in self:
#             record.value2 = float(record.value) / 100

