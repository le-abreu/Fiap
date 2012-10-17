
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
			<h:panelGrid columns="1" >
				<rich:panel header="Upload" style="width: 550px; height: 100px;" >
					<h:panelGroup>
						<rich:fileUpload fileUploadListener="#{handlerLogin.uploadArquivo}" listHeight="20px" listWidth="520px"
		                maxFilesQuantity="10000" id="upload" immediateUpload="true" acceptedTypes="txt, doc" allowFlash="false" />
					</h:panelGroup>
				</rich:panel>
				<rich:panel header="Arquivos" style="width: 550px; height: 150px;" >
					<h:form>
						<rich:dataTable value="#{handlerLogin.arquivos}" var="a"
							border="2" id="tabela" width="530px;" rows="3">
							<h:column>
								<f:facet name="header">
									<h:outputText value="#" />
								</f:facet>
								<h:outputText value="#{a.possuiAssinaturaDigital}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="Funcionario" />
								</f:facet>
								<h:outputText value="#{a.funcionario.nome} #{a.funcionario.sobrenome}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="Arquivo" />
								</f:facet>
								<a href="<h:outputText value='#{a.caminhoArquivo}#{a.nomeArquivo}' />"  target="_blank"><h:outputText value='#{a.nomeArquivo}' /></a>
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