 <%@include file="header.jsp"%>
	<f:view>
		<rich:panel style="width: 1050px; height: 320px;"> 
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
				<h:form>
					<h:panelGrid columns="2">
						<rich:panel style="width: 450px; height: 300px;" header="Pedido">
							<rich:messages style="color:red" />
							<h:panelGrid columns="3">
								<h:outputText value="Nr. Pedido::" />
								<h:inputText value="#{handlerPedido.pedido.numero}" disabled="#{handlerPedido.pedido.finalizado}"/>
								<a4j:commandLink value="Procurar" action="#{handlerPedido.carregar}" />
								<h:outputLabel id="data" value="Data:" />
							    <rich:calendar datePattern="dd/MM/yyyy" value="#{handlerPedido.pedido.data.time}" required="true" requiredMessage="Por favor informe a data!!!" disabled="#{handlerPedido.pedido.finalizado}">
						            <f:convertDateTime type="date"  pattern="dd/MM/yyyy" />   
						         </rich:calendar>  
							</h:panelGrid>
							<h:panelGrid columns="2">
								<h:outputLabel value="Tipo Cliente:"/> 
								<h:selectOneMenu id="tipoCliente" valueChangeListener="#{handlerPedido.tratarTipoCliente}" value="#{handlerPedido.tipoCliente}" onchange="submit()" disabled="#{handlerPedido.pedido.finalizado}">
									<f:selectItem itemLabel="selecione..." />
									<f:selectItems value="#{handlerPedido.tipoClientes}" />
								</h:selectOneMenu>
								
								<h:outputLabel value="Cliente:"/> 
								<h:outputLabel value="Aguardando tipo cliente" rendered="#{handlerPedido.listCliente == null}"/> 
								<h:selectOneMenu id="listaClientes" value="#{handlerPedido.pedido.cliente}" rendered="#{handlerPedido.listCliente != null}" disabled="#{handlerPedido.pedido.finalizado}"> 
									<f:selectItems value="#{handlerPedido.clientes}" />
									<f:converter converterId="br.com.fiap.bean.Cliente"/> 
								</h:selectOneMenu>
								
								<h:outputLabel value="Produto:"/> 
								<h:selectOneMenu id="listaProdutos" value="#{handlerPedido.item.produto}" disabled="#{handlerPedido.pedido.finalizado}"> 
									<f:selectItems value="#{handlerPedido.produtos}" />
									<f:converter converterId="br.com.fiap.bean.Produto"/>  
								</h:selectOneMenu>
		
							</h:panelGrid>
							<h:panelGrid columns="3">
								<h:outputLabel value="Quantidade:"/> 
								<h:inputText id="qtdProduto" value="#{handlerPedido.item.quantidade}" disabled="#{handlerPedido.pedido.finalizado}"/>
								<h:commandButton value="Adicionar Produto" action="#{handlerPedido.adicionarProduto}"/>
							</h:panelGrid>
							</rich:panel>
							<rich:panel header="Itens" style="width: 550px; height: 300px;">
							<h:panelGrid columns="1">
								<rich:dataTable value="#{handlerPedido.pedido.itens}" border="1" var="itemProduto" id="tabela" width="530px;">
									<h:column>
									    <f:facet name="header">
											<h:outputText value="X"/>
										</f:facet>
										<h:commandLink actionListener="#{handlerPedido.removerProduto}"> 
											<h:outputText value="X" />
											<f:param id="idItem" name="id"  value="#{itemProduto.produto.id}"/>
										</h:commandLink>
									</h:column>
									<h:column>
									    <f:facet name="header">
											<h:outputText value="IDProduto"/>
										</f:facet>
										<h:outputText value="#{itemProduto.produto.id}"/>
									</h:column>
									<h:column>
									    <f:facet name="header">
											<h:outputText value="Desc. Produto"/>
										</f:facet>
										<h:outputText value="#{itemProduto.produto.nome}"/>
									</h:column>
									<h:column>
									    <f:facet name="header">
											<h:outputText value="Valor Uni."/>
										</f:facet>
										<h:outputText value="#{itemProduto.produto.valor}">
											<f:convertNumber pattern="R$ ####.00" />
										</h:outputText>
									</h:column>
									<h:column>
									    <f:facet name="header">
											<h:outputText value="Qtd."/>
										</f:facet>
										<h:outputText value="#{itemProduto.quantidade}"/>
									</h:column>
									<h:column>
									    <f:facet name="header">
											<h:outputText value="Desconto"/>
										</f:facet>
										<h:outputText value="#{itemProduto.desconto}"/>
									</h:column>
									<h:column>
									    <f:facet name="header">
											<h:outputText value="Total"/>
										</f:facet>
										<h:outputText value="#{itemProduto.total}">
											<f:convertNumber pattern="R$ ####.00" />
										</h:outputText>
									</h:column>
									 <f:facet name="footer">
							            <rich:columnGroup>
							                <rich:column colspan="6"/>
							                <rich:column>
							                    <h:outputText value="#{handlerPedido.pedido.total}">
							                        <f:convertNumber pattern="R$ ####.00" />
							                    </h:outputText>
							                </rich:column>
							            </rich:columnGroup>
							        </f:facet>
								</rich:dataTable>
								<rich:datascroller for="tabela" maxPages="2" align="center"/>
								<h:panelGrid columns="2">
									<h:outputLabel value="Finalizado?"/>
									<h:selectBooleanCheckbox value="#{handlerPedido.pedido.finalizado}" disabled="#{handlerPedido.pedido.finalizado}"/> 
									<a4j:commandButton value="Salvar" action="#{handlerPedido.salvar}"/>
								</h:panelGrid>
							</h:panelGrid>
						</rich:panel>
					</h:panelGrid>
				</h:form>
			</h:panelGrid>
		</rich:panel>
		<rich:panel header=":: Copyright 2011 - Todos os direitos reservado a LJR SystemWeb ::" style="width: 1050px; height: 30px;"/>
	</f:view>
 <%@include file="footer.jsp"%>
