<div class="sample-layout-template" id="main-content" role="main">
	<div class="portlet-layout row">
		<div class="col-md-12 portlet-column portlet-column-only" id="column-1">
			${processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")}

		</div>
	</div>

	<#assign 
		bId = "com_liferay_site_navigation_breadcrumb_web_portlet_SiteNavigationBreadcrumbPortlet_INSTANCE_SupportLT"
		/>

	<#assign 
		wcPortletId2 = "com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_SupportLT"
		/>
	<#assign 
		wcPortletId3 = "com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_SupportLTBis" + plid!
		/>

	<#assign 	
		preferencesMapB = {"displayStyle": "ddmTemplate_BREADCRUMB-HORIZONTAL-FTL", "portletSetupPortletDecoratorId": "barebone", "showCurrentGroup": "false"} 
		preferencesMap2 = {}
		preferencesMap3 = {} 
	/>


	<div id="emb121">
			Embedded ${bId} ${processor.processPortlet("${bId}", preferencesMapB)}
	</div>
	<div id="emb123">
			Embedded ${wcPortletId2} ${processor.processPortlet("${wcPortletId2}", preferencesMap2)}
	</div>
	<div id="emb124">
			Embedded ${wcPortletId3} ${processor.processPortlet("${wcPortletId3}", preferencesMap3)}
	</div>



</div>