<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="includes/header.html" %>


<form:form method="post"  modelAttribute="surveyFormBean"  class="form columns-view">


<!--error Control-->
<c:if test="${hasError=='Y'}">

    <section id ="form-error" class="form-section questions">
        <div class="wrapper clearfix">
            <div class="form-errors">
                <form:errors path="*" cssClass="errors" />
                <span class="error-mark">!</span>
            </div>
        </div>
    </section>
</c:if>
<!--error Control ends here-->


<form:hidden path="scrollx" value=""/>
<form:hidden path="scrolly" value=""/>

<section class="basic-form">
    <div class="wrapper clearfix">
        <ul class="aligned-left vertical-image-list">
            <li>
                <img src="assets/australia-landscape.jpg" alt=""/>
                <span class="category-title">You have a chance to win a Grand Australia tour</span>
            </li>
            <li>
                <img src="assets/usa-landscape.jpg" alt=""/>
                <span class="category-title">You have a chance to win a Grand America, Coast to Coast tour</span>
            </li>
            <li>
                <img src="assets/china-landscape.jpg" alt=""/>
                <span class="category-title">You have a chance to win a river cruise to see the Great Wall and so much more</span>
            </li>
        </ul>

        <div class="aligned-right form-field-container">
            <h3>Personal details</h3>
            <p>
                Before you vote - please provide some information about yourself.
            </p>


            <ul class="form-field-list">
                <li>
                    <label>Title<span>*</span></label>
                    <div class="select-holder element-container">
                        <form:select path="participantTitle" >
                            <form:option value="Please Select"/>
                            <form:option value="Dr"/>
                            <form:option value="Mr"/>
                            <form:option value="Mrs"/>
                            <form:option value="Miss"/>
                            <form:option value="Ms"/>
                        </form:select>
                    </div>
                </li>
                <li>
                    <label>First name<span>*</span></label>
                    <div class="element-container"><form:input  path="participantFirstName" value= "" /></div>
                </li>
                <li>
                    <label>Last name<span>*</span></label>
                    <div class="element-container"><form:input  path="participantSruname" value= "" /></div>
                </li>
                <li>
                    <label>E-mail<span>*</span></label>
                    <div class="element-container"><form:input  path="participantEmail" value= "" /></div>
                </li>
                <li>
                    <label>Confirm e-mail<span>*</span></label>
                    <div class="element-container"><form:input  path="participantEmailConf" value= "" /></div>
                </li>
                <li>
                    <label>Age<span>*</span></label>
                    <div class="select-holder element-container">
                        <form:select path="participantAgeBand" >
                            <form:option value="Please Select"/>
                            <form:option value="18-25"/>
                            <form:option value="26-30"/>
                            <form:option value="31-40"/>
                            <form:option value="41-50"/>
                            <form:option value="51-60"/>
                            <form:option value="61-70"/>
                            <form:option value="Over 70"/>
                        </form:select>
                    </div>
                </li>
                <li>
                    <label>Gender<span>*</span></label>
                    <div class="select-holder element-container">
                        <form:select path="participantSex" >
                            <form:option value="Please Select"/>
                            <form:option value="Male"/>
                            <form:option value="Female"/>
                            <form:option value="Prefer not to say"/>
                        </form:select>
                    </div>
                </li>
                <li>
                    <label>Postcode or town/city/county<span>*</span></label>
                    <div class="element-container"><form:input  path="participantPostCode" /></div>
                </li>
                <li>
                    <label>How much do you spend annually on your holidays and flights<span>*</span></label>
                    <div class="select-holder element-container">
                        <form:select path="participantSpendingBand" >
                            <form:options items="${spendingBandList}" />
                        </form:select>
                    </div>
                </li>

            </ul>
            <h4>Data protection</h4>
            <div class="text-content">
                <p>
                    Your personal information will be processed to fulfil your request, and help us to improve our products and services and keep you up to date with what we offer. Please confirm your preferences below.                    </p>
                <p>
                    If you would like to receive information on offers and promotions from Times Newspapers Limited, publishers of The Times and The Sunday Times, please tick here.
                </p>
            </div>

            <div class="agreement-checkbox">
                <div class="form-element">
                    <label class="label_check">
                        <form:checkbox path="participantOptIn" />
                        <strong>Your information will be used in accordance with our <a href="http://www.newsprivacy.co.uk" target="_blank">Privacy Policy</a></strong>

                    </label>
                </div>
            </div>



            <div class="text-content">
                <p>
                    By entering your details you will be entered into our prize draw.  You must be over 18 and a UK  or Republic of Ireland resident to be eligible for a prize.  We can&#39;t accept votes from nominees, their employees, directors or family members.  The details of prizes are listed in the terms and conditions. Some prizes are only valid for specific dates.  If you are unable to utilise the prize on those dates, the prize will be redrawn.  All prizes require that the winner and guest will incur some expenses while enjoying their prize &#45; details are listed in the <a href="tc.htm" target="_blank">Terms and Conditions</a>.</p>

            </div>

            <div class="agreement-checkbox">
                <div class="form-element">
                    <label class="label_check c_on">
                            <form:checkbox path="termsAgreed" />
                        <strong>I have read and accept the <a href="tc.htm" target="_blank">Terms &amp; Conditions</a></strong>

                    </label>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="categories">
    <div class="wrapper">

        <h2>Vote now for a chance to win one of these fantastic prizes</h2>
        <strong>By completing this survey you will automatically be placed into our prize draw for a chance of winning one of 14 dream holidays.</strong>
        <ul class="horizontal-image-list">
            <li>
                <div class="logo-holder">
                    <img src="assets/logo/fred-olsen-cruise-lines.jpg" alt="" />
                </div>
                <h4>Fred Olsen</h4>
                <p>Win one of three cruises (European Multi-City, Baltic Capitals and Scandinavian Multi-City)</p>
            </li>
            <li>
                <div class="logo-holder">
                    <img src="assets/logo/hotels-com-logo.jpg" alt="" />
                </div>
                <h4>Hotels.com</h4>
                <p>Win one of six vouchers for hotels worth &pound;250 each</p>
            </li>
            <li>
                <div class="logo-holder">
                    <img src="assets/logo/scenic-tours-logo.jpg" alt="" />
                </div>
                <h4>Scenic Tours</h4>
                <p>Win one of three Scenic Tours (Grand Australia, Grand America and Gems of the Danube)</p>
            </li>
            <li>
                <div class="logo-holder">
                    <img src="assets/logo/viking-river-cruises-logo.jpg" alt="" />
                </div>
                <h4>Viking River Cruises</h4>
                <p>Win a Viking Emerald Cruise</p>
            </li>
            <li>
                <div class="logo-holder">
                    <img src="assets/logo/virgin-holidays-logo.jpg" alt="Virgin Holidays" />
                </div>
                <h4>Virgin Holidays</h4>
                <p>Win a trip to Virgin Holidays&#39; Couples Barbados</p>
            </li>
        </ul>
    </div>
</section>

<section class="form-section questions">
    <div class="wrapper clearfix">
        <h2 class="form-instructions">
            There are 6 categories to vote in (Airlines, Destinations, Hotels, Tour operators, Cruise companies &amp; Website) and you must complete at least 10 questions for your survey to be eligible.
        </h2>
        <p>&nbsp;</p>
    </div>



    <c:forEach items="${categoryItemList}" var="categoryItem" varStatus="status">
        <section class="form-section questions">
            <div class="wrapper clearfix">
                <h2><c:out value="${categoryItem.categoryName}" /></h2>
                <p class="lead">
                    <c:out value="${categoryItem.categoryDetail}" escapeXml="false"/>
                </p>


                <c:forEach items="${categoryItem.formItemsList}" var="formItem" varStatus="status" >
                    <div class="columns">
                        <div class="aligned-left">
                            <h3><c:out value="${formItem.question.text}"/></h3>
                        </div>
                        <div class="aligned-right">
                            <ul class="fields-list">

                                <li>
                                    <div class="form-element">
                                        <form:input path="answerMapText[${formItem.question.txtId}]" cols="20"  placeholder="${formItem.question.placeHolder}" />
                                    </div>
                                </li>

                                <li>
                                    <div class="form-element">
                                        <div class="select-holder element-container">
                                            <form:select path="answerMapDropDown[${formItem.question.questionId}]" >
                                                <form:option value="Or select your favourite from this list."/>
                                                <form:options items="${formItem.presetAnswer.answerList}" />
                                                <form:option value="N/A"/>
                                            </form:select>
                                        </div>
                                    </div>
                                </li>

                                <li>

                                    <div class="form-element">
                                        <form:textarea  path="answerMapCmt[${formItem.question.cmtId}]" cols="20" rows="20" placeholder="Comments: Please use this space if you wish to tell us why you voted for your choice (maximum of 5000 characters)."/>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
    </c:forEach>


</section>


<section class="form-section form-section-submit">
    <button type="submit">Submit my votes</button>
</section>
</form:form>



<%@include file="includes/footer.html" %>

