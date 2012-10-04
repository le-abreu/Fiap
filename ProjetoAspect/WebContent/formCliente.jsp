
<%@include file="header.jsp"%>
<f:view>
	<rich:panel style="width: 1050px; height: 320px;" styleClass="pic">
		<h:panelGrid columns="1">
			<h:form>
				<rich:toolBar height="26px">
					<rich:dropDownMenu style="aling:center;">
						<f:facet name="label">
							<h:panelGroup>
								<h:graphicImage value="/img/icons/copy.gif" styleClass="pic" alt="copy" />
								<h:outputText value="File" />
							</h:panelGroup>
						</f:facet>
						<rich:menuItem value="Cliente" icon="/img/icons/cliente.jpg" action="cliente" />
						<rich:menuItem value="Produto" icon="/img/icons/produto.jpg" action="produto" />
						<rich:menuItem value="Pedido" icon="/img/icons/pedido.jpg" action="pedido" />
					</rich:dropDownMenu>
				</rich:toolBar>
			</h:form>
			<h:panelGrid columns="2">
				<rich:panel style="width: 450px; height: 300px; color:red;"
					header="Cliente">
					<h:form>
						<rich:messages style="color:red" />
						<h:panelGrid columns="3">
							<h:outputLabel id="nome" value="Nome:" />
							<h:inputText value="#{handlerCliente.cliente.nome}" />
							<h:inputHidden value="#{handlerCliente.cliente.id}" />
							<h:outputLabel id="tpCliente" value="Tipo Cliente:" />
							<h:selectOneMenu id="tipoCliente"
								value="#{handlerCliente.cliente.tipoCliente}">
								<f:selectItems value="#{handlerCliente.tipoClientes}" />
							</h:selectOneMenu>
							<a4j:commandButton value="Salvar" action="#{handlerCliente.salvar}" />
						</h:panelGrid>
					</h:form>
				</rich:panel>
				<rich:panel header="Clientes" style="width: 550px; height: 300px;">
					<h:form>
						<rich:dataTable value="#{handlerCliente.clientes}" var="c"
							border="2" id="tabela" width="530px;" rows="5">
							<h:column>
								<f:facet name="header">
									<h:outputText value="Id" />
								</f:facet>
								<h:outputText value="#{c.id}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="Nome" />
								</f:facet>
								<h:outputText value="#{c.nome}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="Tipo" />
								</f:facet>
								<h:outputText value="#{c.tipoCliente}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="Alterar" />
								</f:facet>
								<h:commandLink actionListener="#{handlerCliente.escolheCliente}">
									<h:graphicImage style="border:0px;" value="/img/icons/open.gif"/>
									<f:param id="idCliente" name="id" value="#{c.id}" />
								</h:commandLink>
							</h:column>
						</rich:dataTable>
						<rich:datascroller for="tabela" align="center"/>
					</h:form>
				</rich:panel>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
	<rich:panel header=":: Copyright 2011 - Todos os direitos reservado a LJR SystemWeb ::" style="width: 1050px; height: 30px;"/>
</f:view>
<%@include file="footer.jsp"%>