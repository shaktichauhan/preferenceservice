/*global injectReceipts, receiptDataAlreadyInjected, appendHiddenFields, adobe, jQuery */ /* for jslint */
window.onadobedpscontextloaded = injectReceipts;

function adobeExists() {
    if (window.adobedpscontextloaded) {
        return true;
    }

    return false;
}

function injectReceipts() {
    // Don't inject the receipts if they have already been added to the form
    if(receiptDataAlreadyInjected()){
        return;
    }

    if (adobeExists()){
        adobe.dps.store.getReceiptData(function(data) {
            appendHiddenFields(data);
        });
    }
}

function appendHiddenFields(receipts) {
    var idx, productId, receipt;
    idx = 0;
    for (productId in receipts) {
        if(receipts.hasOwnProperty(productId)){
            receipt = receipts[productId];

            if (jQuery.trim(receipt)) {
                jQuery('form').append(jQuery('<input type="hidden">')
                        .attr('id', 'receipts' + idx + '.receiptData')
                        .attr('name', 'receipts[' + idx + '].receiptData')
                        .attr('value', receipt));

                idx++;
            }
        }
    }
}

function receiptDataAlreadyInjected(){
    //examine the receipt input element and make sure it has a value
    var recEl = jQuery('input[name*="receiptData"]');
    if(recEl && jQuery.trim(recEl.val())){
        return true;
    }

    return false;
}