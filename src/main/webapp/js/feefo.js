(function(jQuery) {
    if(jQuery.eventEmitter) {
        return;
    }
    jQuery.eventEmitter = {
        _JQInit: function() {
            this._JQ = jQuery(this);
        },
        trigger: function(evt, data) {
            !this._JQ && this._JQInit();
            return this._JQ.trigger(evt, data);
        },
        once: function(evt, handler) {
            !this._JQ && this._JQInit();
            return this._JQ.one(evt, handler);
        },
        on: function(evt, handler) {
            !this._JQ && this._JQInit();
            return this._JQ.on(evt, handler);
        },
        off: function(evt, handler) {
            !this._JQ && this._JQInit();
            return this._JQ.off(evt, handler);
        }
    };
}(jQuery));

var feefo = {};

feefo.isWebView = function() {
    if($(window).width() >= 1024) {
        return true;
    }

    return false;
};


feefo.isMobileView = function() {
    if($(window).width() <= 640) {
        return true;
    }

    return false;
};


feefo.isTabletView = function() {
    if($(window).width() > 640 && $(window).width() < 1024) {
        return true;
    }

    return false;
};

$.extend(feefo, $.eventEmitter);