
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
					<rich:fileUpload fileUploadListener="#{handlerLogin.uploadArquivo}"  
		                maxFilesQuantity="1" id="upload" immediateUpload="true" acceptedTypes="txt, doc" allowFlash="false" />
				</rich:panel>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
	<rich:panel header=":: Copyright 2011 - Todos os direitos reservado a LJR SystemWeb ::" style="width: 1050px; height: 30px;"/>
</f:view>
<%@include file="footer.jsp"%>