<?xml version="1.0"?>
<recipe>
		
    <instantiate from="root/src/app_package/SimpleAdapter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${adapterName}.java" />
	
				   
	<instantiate from="root/res/layout/simple_recycle_item.xml.ftl"
				to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
				   
    <open file="${escapeXmlAttribute(srcOut)}/${adapterName}.java" />
	
	<open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.java" />

</recipe>
