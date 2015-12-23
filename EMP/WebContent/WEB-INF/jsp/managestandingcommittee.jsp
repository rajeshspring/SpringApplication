<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<%-- <script type='text/javascript' src="${pageContext.request.contextPath}/profilerdwr/interface/standingCommiteeMemberDAO.js"></script> --%>

<script type="text/javascript" charset="utf-8">

// pagination

$(document).ready(function() {
							oTable = $('#familyTable').dataTable({
								"bJQueryUI": true,
								"aoColumns": [
									  			null,
									  			null,
									  			null,									  			
									  			{ "bSortable": false },
									  			{ "bSortable": false }
									  			],
									"sPaginationType": "full_numbers",
									"bFilter": false
							});
		} ); 
		
		
		

</script>




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<%
String formname="form.DeleteStandCommittee.";
request.setAttribute("formId", formname);
%>

<div class="overlay" id="overlay1" style="display:none;"></div>
    <div class="box" id="box1">
            <a class="boxclose" id="boxclose1"></a>
			<div >
			<c:if test="${!empty param.standing_msg}">
				<table>
								<tr><td rowspan="2"><center><Div class= "success"></div></center></td>
								
								<td ><div  class="helpMsgHeader" style="width:275px;"><h4>Success Message</h4></div></td></tr>
								<tr><td><div id="successMsg" class= "successfont" ><center><c:out value="${param.standing_msg}"></c:out></center></div>
					          </td></tr></table>
				
			</c:if>
				
			
						
						
			<c:if test="${!empty param.standing_msg1}">
				<table>
				<tr><td rowspan="2"><Div class= "failur"></div></td>
				<td><center><div class="helpMsgHeaderflr" style="width:275px;"><b>Alert Message</b></div></center></td></tr>
				<tr><td><div id="failurMsg" class="errorfont"><center> <c:out value="${param.standing_msg1}"></c:out></center> </div>
	        	</td></tr></table>
				</c:if>			
						
						
						
						
							 
			</div>
	</div>


	<form:form action="managestandingcommittee.htm" method="post" commandName="standingCommitteeDetailsForm">
<input type="hidden" name="<csrf:token-name/>" value="<csrf:token-value uri="managestandingcommittee.htm"/>"/>
		<div id="frmcontent">
			<div class="frmhd">
				<table width="100%" class="tbl_no_brdr">
					<tr>
						<td align="left" width="50%"><spring:message code="Label.ManageStanComDetails" />
						</td>
						<td width="70%">
							<center>
							</center>
							</td>
                      <td width="100" align="right" valign="middle"><a  href="media/ManageStanComDetails/ManageStanComDetails.html" target="_blank" rel="gb_page_center[1400, 600]" class="cbthelp" target="_blank">CBT</a></td>
                         <td width="60" align="right"><a href="viewManualHelp.do?formName=${formId}&languageId=${languageHelp}&<csrf:token uri='viewManualHelp.do'/>" class="frmhelp"    target="_blank" rel="gb_page_center[800, 600]"><spring:message code="Label.Help" /> </a></td>         
    
                        </tr>
						</table>
						</div>
		

		 				
		<div class="clear"></div>			
		<div class="frmpnlbrdr">				
		<div class="frmpnlbg">
		<div class="frmtxt">
		<div class="frmhdtitle">Search Box</div>

				<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr valign="top">
				<td width="75%"><label><spring:message	code="Label.CommitteeType" /></label><br /> <form:select
				path="committeeType" id="committeeType" cssClass="combofield"  cssStyle="width:250px;"
				onfocus="validateOnFocus('committeeType')"
				onblur="vlidateOnblur('committeeType','1','75','m')" >



													<form:option value=""><spring:message code="Label.Select" /></form:option>
													<c:forEach items="${commiteeType}" var="commitee_type">
													<form:option value="${commitee_type.committeetypeid}"><spring:message code="${commitee_type.resourceId}"></spring:message></form:option>
													</c:forEach>
					
					</form:select>
					</td>
					</tr>
				<td></td>
				
					<div class="btnpnl">
					 <table width="100%" class="tbl_no_brdr">
					<tr valign="top">
						<td align="left"><label><spring:message	code="Label.CommitteeName" /></label> <br/>												
							<form:input path="searchKey" cssClass="frmfield" cssStyle="width:250px;" /> <br/><br/>
							<input type="submit" class="btn"  value="<spring:message code="Button.GetData" />">
							<input name="reset" class="btn"  type="reset" value=<spring:message code="Button.Clear" /> />
							 <input  type="button" class="btn" onclick="onClose('home.htm?<csrf:token uri='home.htm'/>')"  value=<spring:message code="Button.Close" /> />
					</tr>
				</table>
				</div>

			<c:if test="${!empty resultFound}">
			<center style="color: red; font-weight: bolder;"><c:out value="${resultFound}"/></center>
		</c:if>

		<!--  displaying list of  -->
		<c:if test="${!empty managestandingcommittee}">
		<div class="frmpnlbg">
           <div class="frmtxt">
             <div class="frmhdtitle">Results found</div>
              <table width="100%">																			                        
					<tr>    
						<td width="16%">
		
                   <table class="tbl_with_brdr display" id="familyTable">
             
			         <thead>
			          <tr class="tblRowTitle tblclear">
                      <th class='columns_head' rowspan="2" align="left"> <spring:message code="Label.S.No."/> </th>
                      <th class='columns_head' rowspan="2" align="left">Committee Type  </th>
                      <th class='columns_head' rowspan="2" align="left"> Committee Name </th> 
            	      <th class='columns_head' rowspan="2" align="left"> Local Body Type </th>
            	       <th class='columns_head' rowspan="2" align="left"> Applicable At</th>
                      <th class='columns_head'  colspan="3" align="center"><spring:message code="Label.Action"/></th>
                   	</tr>
                   	
                   	 <tr class="tblRowTitle tblclear topTr">
                      <th class='columns_head' align="left"><spring:message code="Label.View"/></th>
			          <th class='columns_head' align="left"><spring:message code="Label.Modify"/></th>
			          <th class='columns_head' align="left"><spring:message code="Label.Delete"/></th>
                   	</tr>
                   	</thead>
                        
                    	<%   
                 			 	  int view=0;
			                      int update=0;
			                      int delete=0;%>
                 
                 				 <c:forEach items="${forms}" var="form">
			                      
			                      <c:forEach items='${form.privileges}' var="privileges">
			                      
			                     
			               
			                      <c:if test="${privileges.type == 'viewstandingCommittee.htm'}">
			                    
			                      <%view=1; %>
			                    </c:if>
			                    
			                      <c:if test="${privileges.type== 'updatestandingCommittee.htm'}">
			                        
			                      <%update=1; %>
			                    </c:if>
			                    
			                      <c:if test="${privileges.type== 'deletestandingCommittee.htm'}">
			              
			                      <%delete=1; %>
			                    </c:if>
			                    
			                    
			                    </c:forEach>
			                    </c:forEach>    
                                			 	
                
                 				<tbody>
			                    <c:forEach items="${managestandingcommittee}" var="standingcommittee" varStatus="count">
			                    <tr> 
			                      <td class='form_text' width="5%">${count.count}.</td>
			                      <td class='form_text' width="20%"><c:out value="${standingcommittee.lastUpdatedby}" /></td>
			                      <td class='form_text' width="20%"><c:out value="${standingcommittee.committeeName}" /></td>
			                      <td class='form_text' width="6%"><c:choose ><c:when test="${standingcommittee.localbodyType=='p'}">RLB</c:when> <c:otherwise>ULB</c:otherwise></c:choose>
									</td>
			                      <td class='form_text' width="20%"><c:out value="${standingcommittee.createdBy}"></c:out> </td>    
			                                  
			                      <%if(view == 1){%>
			                     <td class='form_text'  width="6%" align="left"><a href="viewstandingCommittee.htm?id=<c:out value="${standingcommittee.committeeId}"/>&<csrf:token uri='viewstandingCommittee.htm'/>"><img src="images/view.png" width="18" height="19" border="0"  /></a></td>
			                       <%} %>
			                       
			                      <%if(update == 1){%>
			                      <td class='form_text' width="6%" align="left"><a href="updatestandingCommittee.htm?id=<c:out value="${standingcommittee.committeeId}"/>&<csrf:token uri='updatestandingCommittee.htm'/>"><img src="images/edit.png" width="18" height="19" border="0" /></a></td>
			                        <%} %> 
			                          
			                       <%if(delete == 1){%>                       
			                      <td class='form_text' width="6%" align="left"><a href="deletestandingCommittee.htm?id=<c:out value="${standingcommittee.committeeId}"/>&<csrf:token uri='deletestandingCommittee.htm' />"><img src="images/delete.png" width="18" height="19" border="0"  /></a></td>
			                       <%} %> 
			                   	 </tr>  
			             </c:forEach>  
			           </tbody>
                    </table>
      </td>
    </tr>
    </table>
    </div>
	</div>
	
	</c:if>	
</div>
</div>

</form:form>
</body>
</html>
                   
             
             
            