
<%@include file="header.jsp"%>
<f:view>
	<rich:panel style="width: 1050px; height: 320px;">
		<h:panelGrid columns="1">
			<h:form>
				<rich:toolBar height="26px">
					<rich:dropDownMenu style="aling:center;">
						<f:facet name="label">
							<h:panelGroup>
								<h:graphicImage value="/img/icons/copy.gif" styleClass="pic"
									alt="copy" />
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
				<rich:panel style="width: 450px; height: 300px;" header="Produto">
					<h:form>
						<rich:messages style="color:red" />
						<h:panelGrid columns="3">
							<h:outputLabel id="produto" value="Produto:" />
							<h:inputText value="#{handlerProduto.produto.nome}" />
							<h:inputHidden value="#{handlerProduto.produto.id}" />
							<h:outputLabel id="valor" value="Valor:" />
							<h:inputText value="#{handlerProduto.produto.valor}" />
							<a4j:commandButton value="Salvar"
								action="#{handlerProduto.salvar}" />
						</h:panelGrid>
					</h:form>
				</rich:panel>
				<rich:panel header="Produtos" style="width: 550px; height: 300px;">
					<h:form>
						<rich:dataTable value="#{handlerProduto.produtos}" var="p"
							border="2" id="tabela" width="530px;" rows="8">
							<h:column>
								<f:facet name="header">
									<h:outputText value="Id" />
								</f:facet>
								<h:outputText value="#{p.id}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="Produto" />
								</f:facet>
								<h:outputText value="#{p.nome}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="Valor" />
								</f:facet>
								<h:outputText value="#{p.valor}">
									<f:convertNumber pattern="R$ ####.00" />
								</h:outputText>
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="Alterar" />
								</f:facet>
								<h:commandLink actionListener="#{handlerProduto.escolheProduto}">
									<h:graphicImage style="border:0px;" value="/img/icons/open.gif"/>
									<f:param id="idProduto" name="id" value="#{p.id}" />
								</h:commandLink>
							</h:column>
						</rich:dataTable>
						<rich:datascroller for="tabela" maxPages="2" align="center" />
					</h:form>
				</rich:panel>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
	<rich:panel
		header=":: Copyright 2011 - Todos os direitos reservado a LJR SystemWeb ::"
		style="width: 1050px; height: 30px;" />
</f:view>
<%@include file="footer.jsp"%>