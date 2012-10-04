<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:: Project Aspecto - AOP ::</title>
</head>
<body>
	<f:view>
		<h:form>
			<rich:toolBar height="26px">
				<rich:dropDownMenu>
					<f:facet name="label">
						<h:panelGroup>
							<h:graphicImage value="/img/icons/copy.gif" styleClass="pic" alt="copy" />
							<h:outputText value="File" />
						</h:panelGroup>
					</f:facet>
				 	<rich:menuItem value="Cliente" icon="/img/icons/open.gif" action="cliente"/>
				 	<rich:menuItem value="Produto" icon="/img/icons/open.gif" action="produto"/>
				 	<rich:menuItem value="Pedido" icon="/img/icons/open.gif" action="pedido"/>
				</rich:dropDownMenu>
			</rich:toolBar>
		</h:form>
	</f:view>
</body>
</html>