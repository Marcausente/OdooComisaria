# -*- coding: utf-8 -*-

# from odoo import models, fields, api


# class modulo_trabajo_marc(models.Model):
#     _name = 'modulo_trabajo_marc.modulo_trabajo_marc'
#     _description = 'modulo_trabajo_marc.modulo_trabajo_marc'

#     name = fields.Char()
#     value = fields.Integer()
#     value2 = fields.Float(compute="_value_pc", store=True)
#     description = fields.Text()
#
#     @api.depends('value')
#     def _value_pc(self):
#         for record in self:
#             record.value2 = float(record.value) / 100

