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
			<rich:menuItem value="Sair" icon="/img/icons/produto.jpg" action="#{handlerLogin.sair}" />
		</rich:dropDownMenu>
	</rich:toolBar>
</h:form>