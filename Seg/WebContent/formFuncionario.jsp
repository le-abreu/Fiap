
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
						<rich:menuItem value="Funcionario" icon="/img/icons/cliente.jpg" action="funcionario" />
						<rich:menuItem value="Arquivo" icon="/img/icons/produto.jpg" action="arquivo" />
					</rich:dropDownMenu>
				</rich:toolBar>
			</h:form>
			<h:panelGrid columns="2">
				<rich:panel style="width: 550px; height: 300px; color:red;"
					header="Funcionario">
					<h:form>
						<rich:messages style="color:red" />
						<h:panelGrid columns="4">
							<h:outputLabel id="chapa" value="Chapa:" style="aling: right;" />
							<h:inputText value="#{handlerFuncionario.funcionario.chapa}" />
							
							<h:outputLabel value="Cargo:" id="cargo"/>
							<h:selectOneMenu id="tipoCliente" value="#{handlerFuncionario.funcionario.cargo}" onchange="submit()">
								<f:selectItem itemLabel="selecione..." />
								<f:selectItems value="#{handlerFuncionario.cargos}" />
							</h:selectOneMenu>

							<h:outputLabel id="nome" value="Nome:" />
							<h:inputText value="#{handlerFuncionario.funcionario.nome}" />
							
							<h:outputLabel id="sobrenome" value="Sobrenome:" />
							<h:inputText value="#{handlerFuncionario.funcionario.sobrenome}" />
							
							<h:outputLabel id="dataNascimento" value="Data Nascimento:" />
						    <rich:calendar datePattern="dd/MM/yyyy" value="#{handlerFuncionario.funcionario.dataNascimento}">
					            <f:convertDateTime type="date"  pattern="dd/MM/yyyy" />   
					         </rich:calendar>  
							
							<h:outputLabel id="dataAdmissao" value="Data Admissão:" />
						    <rich:calendar datePattern="dd/MM/yyyy" value="#{handlerFuncionario.funcionario.dataAdmissao}" >
					            <f:convertDateTime type="date"  pattern="dd/MM/yyyy" />   
					         </rich:calendar>  
							
							<h:outputLabel id="usuario" value="Usuario:" />
							<h:inputText value="#{handlerFuncionario.funcionario.usuario}" />
							
							<h:outputLabel id="chavePublica" value="Chave Publica:" />
							<h:inputText value="#{handlerFuncionario.funcionario.senha}" />
							
							<a4j:commandButton value="Salvar" action="#{handlerFuncionario.salvar}" />
						</h:panelGrid>
					</h:form>
				</rich:panel>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
	<rich:panel header=":: Copyright 2011 - Todos os direitos reservado a LJR SystemWeb ::" style="width: 1050px; height: 30px;"/>
</f:view>
<%@include file="footer.jsp"%>