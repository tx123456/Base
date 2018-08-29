<?xml version="1.0"?>
<recipe>
    
	<merge from="root/AndroidManifest.xml.ftl"
        to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />
		
    <instantiate from="root/src/app_package/SimpleActivity.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${activityName}.java" />
				   
	<#if mvp>			   
	<instantiate from="root/src/app_package/SimplePresenter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${presenterName}.java" />
    <open file="${escapeXmlAttribute(srcOut)}/${presenterName}.java" />
	
	<instantiate from="root/src/app_package/SimpleView.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${viewName}.java" />	
				   
	<open file="${escapeXmlAttribute(srcOut)}/${viewName}.java" />
	</#if>			   
	
	
				   
	<instantiate from="root/res/layout/simple_activity.xml.ftl"
				to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
				   
    <open file="${escapeXmlAttribute(srcOut)}/${activityName}.java" />
	

	<open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.java" />

</recipe>
