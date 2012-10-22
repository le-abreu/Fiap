<%@include file="../header.jsp"%>
<f:view>
	<rich:panel style="width: 1050px; height: 320px;" styleClass="pic">
		<h:panelGrid columns="1">
			<%@include file="menu.jsp"%>
			<h:form>
				<rich:messages style="color:red" />
				<rich:panel header="Funcionários" style="width: 550px; height: 150px;" >
					
					<rich:dataTable value="#{handlerFuncionario.listFuncionarios}" var="f"
						border="2" id="tabela" width="530px;" rows="3">
						<h:column>
							<f:facet name="header">
								<h:outputText value="#" />
							</f:facet>
							<h:outputText value="#{f.nome}" />
						</h:column>
						<h:column>
						    <f:facet name="header">
								<h:outputText value="Promover Funcionario?"/>
							</f:facet>
							<h:commandLink actionListener="#{handlerFuncionario.promoverFuncionario}"> 
								<h:outputText value="Promover" />
								<f:param id="chapa" name="chapa"  value="#{f.chapa}"/>
							</h:commandLink>
						</h:column>
					</rich:dataTable>
					
					<rich:datascroller for="tabela" align="center"/>
				</rich:panel>
			</h:form>
		</h:panelGrid>
	</rich:panel>
	<rich:panel header=":: Copyright 2011 - Todos os direitos reservado a LJR SystemWeb ::" style="width: 1050px; height: 30px;"/>
</f:view>
<%@include file="../footer.jsp"%>