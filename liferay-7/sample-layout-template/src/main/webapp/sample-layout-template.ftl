<div class="sample-layout-template" id="main-content" role="main">
	<div class="portlet-layout row">
		<div class="col-md-12 portlet-column portlet-column-only" id="column-1">
			${processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")}

			<#assign 
				bId = "com_liferay_site_navigation_breadcrumb_web_portlet_SiteNavigationBreadcrumbPortlet_INSTANCE_Support" 
				/>
			<#assign 
				wcPortletId1 = "com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_Support"
				/>
			<#assign 
				wcPortletId2 = "com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_SupportBis"
				/>
			<#assign 
				wcPortletId3 = "com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_SupportTris" + plid!
				/>
			<#assign 	
				preferencesMapB = {"displayStyle": "ddmTemplate_BREADCRUMB-HORIZONTAL-FTL", "portletSetupPortletDecoratorId": "decorate", "showCurrentGroup": "false"} 
				preferencesMap1 = {} 
				preferencesMap2 = {}
				preferencesMap3 = {} 
			/>


			Embedded ${bId} ${processor.processPortlet("${bId}", preferencesMapB)}

			Embedded1 ${wcPortletId1} ${processor.processPortlet("${wcPortletId1}", preferencesMap1)}
			Embedded2 ${wcPortletId2} ${processor.processPortlet("${wcPortletId2}", preferencesMap2)}
			Embedded3 ${wcPortletId3} ${processor.processPortlet("${wcPortletId3}", preferencesMap3)}

		</div>
	</div>

	<div class="portlet-layout row">
		<div class="col-md-8 portlet-column portlet-column-first" id="column-2">
			${processor.processColumn("column-2", "portlet-column-content portlet-column-content-first")}
		</div>

		<div class="col-md-4 portlet-column portlet-column-last" id="column-3">
			${processor.processColumn("column-3", "portlet-column-content portlet-column-content-last")}
		</div>
	</div>

	<div class="portlet-layout row">
		<div class="col-md-12 portlet-column portlet-column-only" id="column-4">
			${processor.processColumn("column-4", "portlet-column-content portlet-column-content-only")}
		</div>
	</div>
</div>