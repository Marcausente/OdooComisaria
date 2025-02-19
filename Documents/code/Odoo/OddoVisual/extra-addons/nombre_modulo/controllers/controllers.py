# -*- coding: utf-8 -*-
# from odoo import http


# class NombreModulo(http.Controller):
#     @http.route('/nombre_modulo/nombre_modulo', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/nombre_modulo/nombre_modulo/objects', auth='public')
#     def list(self, **kw):
#         return http.request.render('nombre_modulo.listing', {
#             'root': '/nombre_modulo/nombre_modulo',
#             'objects': http.request.env['nombre_modulo.nombre_modulo'].search([]),
#         })

#     @http.route('/nombre_modulo/nombre_modulo/objects/<model("nombre_modulo.nombre_modulo"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('nombre_modulo.object', {
#             'object': obj
#         })

