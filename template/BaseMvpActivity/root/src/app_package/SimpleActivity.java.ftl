package ${packageName};


@Route(path = "")
<#if mvp>
@CreatePresenter(presenter = ${presenterName}.class)
</#if>
<#if useTitle>
<#if mvp>
public class ${activityName} extends BaseTitleMvpActivity<${presenterName}> implements ${viewName}{
<#else>
public class ${activityName} extends BaseTitleMvpActivity{
</#if>
<#else>
<#if mvp>
public class ${activityName} extends BaseMvpActivity<${presenterName}> implements ${viewName}{
<#else>
public class ${activityName} extends BaseMvpActivity{
</#if>
</#if>

	public static void startActivity(){
        ARouter.getInstance().build("").navigation();
    }

	@Override
    protected int bindLayout() {
        return R.layout.${layoutName};
    }
	
    @Override
    protected void onEventComing(BaseEvent event) {

    }
	
	@Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
		<#if useTitle>
		qmuiTopBar.setTitle("${name}");
		</#if>
    }

}
