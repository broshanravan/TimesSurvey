<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="includes/headerThanks.html" %>
<c:choose>
    <c:when test="${alreadyEntered=='Y'}">
        <div class="wrapper">
            <section class="categories">
                <div class="wrapper">
                    <p>&nbsp;</p>
                    <p>&nbsp;</p>
                    <h2 style="color: #ff0000">The vote for this email has already been entered</h2>
                    <h5 style="color: #ff0000">Only one entry per email</h5>
                </div>
            </section>
        </div>



    </c:when>

    <c:otherwise>

        <section class="categories">
            <div class="wrapper">
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <h2>Thank you for taking part in The Travel Awards 2013</h2>

                <p class="float-left">
                    Your votes have been submitted and your name will be entered into the prize draw. If you are successful you will be contacted when the voting period closes after September 5. Look out for the results in The Times, The Sunday Times and The Sunday Times Travel Magazine around this time. Good luck!
                </p>




                <p class="float-left">
                    <strong>Why pay more? Save &pound;6 a week with a subscription to the Times</strong>



                    The Classic pack gives you &pound;12 worth of content for only &pound;6. Get the papers every day, smartphone and web access with Times+ membership.

                    <br />
                    <br />

                    Call 0800 092 2712 and quote 'classic6' or <a style="color:#10A193" href="http://timespacks.com/classic6">visit timespacks.com/classic6</a>


                </p>




            </div>
        </section>

    </c:otherwise>
</c:choose>
<!--Extra space -->

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>






<%@include file="includes/footerthanks.html" %>


