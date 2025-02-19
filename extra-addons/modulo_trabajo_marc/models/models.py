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
