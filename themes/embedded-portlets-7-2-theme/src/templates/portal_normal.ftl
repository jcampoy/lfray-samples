<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="container-fluid" id="wrapper">
	<header id="banner" role="banner">
				<#assign preferences = freeMarkerPortletPreferences.getPreferences({"portletSetupPortletDecoratorId": "barebone", "destination": "/search"}) />

		<div class="autofit-col autofit-col-expand">
	
				<div class="justify-content-md-end mr-4 navbar-form" role="search">
					<@liferay.search_bar default_preferences="${preferences}" />
				</div>

		</div>

		<div id="heading">
			<h1 class="site-title">
				<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
				</a>

				<#if show_site_name>
					<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						${site_name}
					</span>
				</#if>
			</h1>
		</div>

		<#if !is_signed_in>
			<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>
		</#if>

		<#if has_navigation && is_setup_complete>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
	</header>

	<section id="content">
		<h1 class="hide-accessible">${the_title}</h1>

		<nav id="breadcrumbs">
			<@liferay.breadcrumbs />
		</nav>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>
	<div id="loquesea">

		com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_SupportT${plid}
		<@liferay_portlet["runtime"]
			instanceId="SupportT${plid}"
			portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
		/>

<br/>dashboardHeaderDesktop
				<@liferay_portlet["runtime"]
					defaultPreferences="${freeMarkerPortletPreferences}"
					instanceId="dashboardHeaderDesktop"
				    portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
				/>
<br/>dashboardHeaderDesktop2
				<@liferay_portlet["runtime"]
					defaultPreferences="${freeMarkerPortletPreferences}"
					instanceId="dashboardHeaderDesktop2"
				    portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet"
				/>

	</div>
	<footer id="footer" role="contentinfo">
		<p class="powered-by">
			<@liferay.language key="powered-by" /> <a href="http://www.liferay.com" rel="external">Liferay</a>
		</p>
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<!-- inject:js -->
2090
<!-- endinject -->

</body>

</html>