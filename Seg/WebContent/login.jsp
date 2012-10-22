
<%@include file="header.jsp"%>
<f:view>
	<rich:panel style="width: 1050px; height: 350px;" styleClass="pic">
		<h:panelGrid columns="1">
			<h:panelGrid columns="2">
				<rich:panel header=":: Area de Acesso ::" style="aling:center;">
					<h:form>
						<h:panelGrid columns="2">
							<h:outputText value="#{handlerLogin.result}" style="color:red" />
							<rich:messages style="color:red" />
							<h:panelGrid columns="2">
								<h:outputLabel value="Login:"/>
								<h:inputText id="login" value="#{handlerLogin.funcionario.usuario}"/>
								<h:outputLabel value="Senha:"/>
								<h:inputSecret id="senha" value="#{handlerLogin.funcionario.senha}"/>
							</h:panelGrid>							
							<a4j:commandButton image="img/imagem_cadeado.jpg" action="#{handlerLogin.login}" />
						</h:panelGrid>
					</h:form>
				</rich:panel>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
	<rich:panel header=":: Copyright 2011 - Todos os direitos reservado a JLRSystemWeb ::" style="width: 1050px; height: 30px;"/>
</f:view>
<%@include file="footer.jsp"%>