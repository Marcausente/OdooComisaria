# -*- coding: utf-8 -*-
{
    'name': "Gestión Policial",
    'summary': "Sistema de gestión para comisarías de policía",
    'description': """
        Módulo para gestionar:
        - Agentes de policía
        - Comisarías
        - Rangos y divisiones
        - Armamento
    """,
    'author': "Tu Nombre",
    'category': 'Human Resources',
    'version': '1.0',
    'depends': ['base', 'mail'],
    'data': [
        'security/ir.model.access.csv',
        'views/views.xml',
    ],
    'application': True,
    'installable': True,
    'auto_install': False,
}

