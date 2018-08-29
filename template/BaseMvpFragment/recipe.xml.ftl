<?xml version="1.0"?>
<recipe>
		
    <instantiate from="root/src/app_package/SimpleFragment.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${fragmentName}.java" />
	
	<#if mvp>
	<instantiate from="root/src/app_package/SimplePresenter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${presenterName}.java" />
	<open file="${escapeXmlAttribute(srcOut)}/${presenterName}.java" />		

	<instantiate from="root/src/app_package/SimpleView.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${viewName}.java" />	
				   
	<open file="${escapeXmlAttribute(srcOut)}/${viewName}.java" />			   
	</#if>
	
				   
	<instantiate from="root/res/layout/simple_fragment.xml.ftl"
				to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
				   
    <open file="${escapeXmlAttribute(srcOut)}/${fragmentName}.java" />
	
	<open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.java" />

</recipe>
