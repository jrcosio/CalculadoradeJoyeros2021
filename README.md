# VerificarQRCovid
App para Android para verificar la validadez de los certificados de vacunanción Covid19 expedidos en EUROPA.

Diseñada y programada por JOSÉ RAMÓN BLANCO GUTIÉRREZ

[![Twitter URL](https://img.shields.io/twitter/url?style=social&url=https%3A%2F%2Ftwitter.com%2Fjr_blanco_)](https://twitter.com/jr_blanco_)

Documento Oficial del Parlamento Europeo que define la estructura del JSON que contiene el QR Covid:
- URL: https://ec.europa.eu/health/sites/default/files/ehealth/docs/covid-certificate_json_specification_en.pdf

Documento Oficial del Parlamento Europeo que define los valores del Certificado Covid
- URL: https://ec.europa.eu/health/sites/default/files/ehealth/docs/digital-green-value-sets_en.pdf

# Librerias externas utilizas

# ZXing Android Embedded
Descripción: Libreria utilizada para el uso de la camara como escaner de QR.
- URL: https://github.com/journeyapps/zxing-android-embedded

# Base45
Descripción: Libreria utilizada en el proceso de decodificación del certificado Covid
- URL: https://github.com/ehn-dcc-development/base45-java

# CborTree
Descripción: Una vez decodificado y Descomprimido el QR esta libreria crea el arbol JSON
- URL: https://github.com/google/cbortree#cbortree
- URL: https://github.com/cose-wg/COSE-JAVA

Agradecimiento y mención especial a Gaetano Piazzolla:
- https://github.com/GaetanoPiazzolla/greenpass-decode
- https://gae-piaz.medium.com/decode-the-eu-green-pass-qrcode-using-java-b5654e55b0fc
