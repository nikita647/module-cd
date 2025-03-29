package org.common

def call(String message) {
    stage('Manual  Approval') {
    input message: message, ok: 'Proceed'
    }
}
