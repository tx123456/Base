package ${packageName};

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;


public class ${adapterName} extends BaseQuickAdapter<${dataName},BaseViewHolder> {
    public ${adapterName}(@Nullable List<${dataName}> data) {
        super(R.layout.${layoutName}, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ${dataName} item) {

    }
}