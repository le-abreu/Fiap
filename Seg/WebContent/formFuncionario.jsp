<%@include file="header.jsp"%>
<f:view>
	<rich:panel style="width: 1050px; height: 320px;" styleClass="pic">
		<h:panelGrid columns="1">
			<%@include file="menu.jsp" %>
			<h:panelGrid columns="2">
				<rich:panel style="width: 550px; height: 300px; color:red;"
					header="Funcionario">
					<h:form>
						<rich:messages style="color:red" />
						<h:panelGrid columns="2">
							<h:outputLabel value="Cargo:" id="cargo"/>
							<h:selectOneMenu id="tipoCliente" value="#{handlerFuncionario.funcionario.cargo}" onchange="submit()">
								<f:selectItem itemLabel="selecione..." />
								<f:selectItems value="#{handlerFuncionario.cargos}" />
							</h:selectOneMenu>
							
							<h:outputLabel id="dataAdmissao" value="Dt Admissão:" />
						    <rich:calendar datePattern="dd/MM/yyyy" value="#{handlerFuncionario.funcionario.dataAdmissao}" >
					            <f:convertDateTime type="date"  pattern="dd/MM/yyyy" />   
					         </rich:calendar>  

							<h:outputLabel id="nome" value="Nome:" />
							<h:inputText value="#{handlerFuncionario.funcionario.nome}" />
							
							<h:outputLabel id="sobrenome" value="Sobrenome:" />
							<h:inputText value="#{handlerFuncionario.funcionario.sobrenome}" />
							
							<h:outputLabel id="dataNascimento" value="Dt Nascimento:" />
						    <rich:calendar datePattern="dd/MM/yyyy" value="#{handlerFuncionario.funcionario.dataNascimento}">
					            <f:convertDateTime type="date"  pattern="dd/MM/yyyy" />   
					         </rich:calendar>  
							
							<h:outputLabel id="login" value="Login:" />
							<h:inputText value="#{handlerFuncionario.funcionario.usuario}" />
							
							<h:outputLabel id="senha" value="Senha:" />
							<h:inputSecret value="#{handlerFuncionario.funcionario.senha}" />
							
							<h:outputText value="" />
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