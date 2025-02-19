# -*- coding: utf-8 -*-
# from odoo import http


# class ModuloTrabajoMarc(http.Controller):
#     @http.route('/modulo_trabajo_marc/modulo_trabajo_marc', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/modulo_trabajo_marc/modulo_trabajo_marc/objects', auth='public')
#     def list(self, **kw):
#         return http.request.render('modulo_trabajo_marc.listing', {
#             'root': '/modulo_trabajo_marc/modulo_trabajo_marc',
#             'objects': http.request.env['modulo_trabajo_marc.modulo_trabajo_marc'].search([]),
#         })

#     @http.route('/modulo_trabajo_marc/modulo_trabajo_marc/objects/<model("modulo_trabajo_marc.modulo_trabajo_marc"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('modulo_trabajo_marc.object', {
#             'object': obj
#         })

