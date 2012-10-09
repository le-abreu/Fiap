
<%@include file="header.jsp"%>
<f:view>
	<rich:panel style="width: 1050px; height: 350px;" styleClass="pic">
		<h:panelGrid columns="1">
			<h:panelGrid columns="2">
				<rich:panel header=":: Area de Acesso ::" style="aling:center;">
					<h:form>
						<rich:messages style="color:red" />
						<h:panelGrid columns="2">
							<h:panelGrid columns="2">
								<h:outputLabel value="Usuario:"/>
								<h:inputText id="usuario" value="#{handlerLogin.funcionario.usuario}"/>
								<h:outputLabel value="Chave Acesso:"/>
								<h:inputText id="chaveAcessoa" value="#{handlerLogin.funcionario.chavePublica}"/>
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