package ${packageName};


@Route(path = "")
<#if mvp>
@CreatePresenter(presenter = ${presenterName}.class)
</#if>
<#if mvp>
public class ${fragmentName} extends BaseMvpFragment<${presenterName}> implements ${viewName}{
<#else>
public class ${fragmentName} extends BaseMvpFragment{
</#if>

	public static BaseFragment startFragment(){
        return (BaseFragment) ARouter.getInstance().build("").navigation();
    }

	@Override
    public int getContentViewId() {
        return R.layout.${layoutName};
    }

    @Override
    protected void onEventComing(BaseEvent event) {

    }
	
	@Override
    protected void initView() {
        
    }

}
