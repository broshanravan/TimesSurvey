// cookie-notification-popup
$(document).ready(function(){
    var formDOM = $("#surveyFormBean");

    // ie8 placeholder polyfill
    if($.fn.placeholder) {
        $('input, textarea').placeholder();
    }

    $("select").msDropdown({
        visibleRows:4,
        on: {
            change: function(obj, el) {
                // retriger validation
                $(el).parents(".select-holder").find("select").valid();
            },
            open:function(obj, el) {
                $(".form-section:not(.form-section-submit)").css("z-index", 25);
                $(el).parents(".form-section:not(.form-section-submit)").css("z-index", 50);
            }
        }
    });

    $('.label_check, .label_radio').click(function(){
        setupLabel();
    });

    jQuery.validator.addMethod("valueNotEquals", function(value, element, arg){
        return arg != value;
    }, "Value must not equal arg.");
    jQuery.validator.addMethod('phoneUK', function(phone_number, element) {
        return this.optional(element) || phone_number.length > 9 &&
            phone_number.match(/^(((\+44)? ?(\(0\))? ?)|(0))( ?[0-9]{3,4}){3}$/);
    }, 'Please specify a valid phone number');

    formDOM.validate({
        rules: {
            "participantFirstName": {
                required: true
            },
            "participantSruname": {
                required: true
            },

            "participantEmail": {
                required: true,
                email: true
            },
            "participantEmailConf": {
                required: true,
                equalTo: "#participantEmail"
            },
            "participantPostCode": {
                required: true
            }
        },
        messages: {
            "participantEmail": "Please enter a valid email address",
            "participantEmailConf": "Email addresses do not match"
        },
        highlight: function (element, errorClass, validClass) {
            if(!$(element).attr("rows")) {
                $(element).parents("li").addClass(errorClass).removeClass(validClass);
            }

        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents("li").removeClass(errorClass).addClass(validClass);
        }
    });
    formDOM.find("select").each(function(){
        $(this).rules("add", {
            valueNotEquals: "Please Select",
            required: true,

            messages: {
                valueNotEquals : "This is a required field"
            }
        });
    });
    formDOM.find("textarea").each(function(){
        $(this).rules("add", {
            required: false
        });
    });

    $(".fields-list select").on("change", function() {
        var $this = $(this), isQuestionSet = false;

        if($this.val() === "Please Select") {
            formDOM.find(".fields-list select").each(function(){
                if($(this).val() !== "Please Select") {
                    isQuestionSet = true;
                    return;
                }
            });

            if(!isQuestionSet) {
                formDOM.find(".fields-list select").each(function(){
                    $(this).rules("add", {
                        valueNotEquals: "Please Select",
                        required: true,

                        messages: {
                            valueNotEquals : "This is a required field"
                        }
                    });
                });
            }
        } else {
            formDOM.find(".fields-list select").each(function(){
                $(this).rules("remove", "required valueNotEquals");
                $(this).valid();
            });
        }
        formDOM.validate();
    });

    setupLabel();

    function setupLabel() {
        if ($('.label_check input').length) {
            $('.label_check').each(function(){
                $(this).removeClass('c_on');
            });
            $('.label_check input:checked').each(function(){
                $(this).parent('label').addClass('c_on');
            });
        };

        if ($('.label_radio input').length) {
            $('.label_radio').each(function(){
                $(this).removeClass('r_on');
            });

            $('.label_radio input:checked').each(function(){
                $(this).parent('label').addClass('r_on');
            });
        };
    };
});