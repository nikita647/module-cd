package org.terraform

def manualApproval(String message) {
    input message: message, ok: 'Proceed'
}
