package jingou.jo.com.dome;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.imangazaliev.circlemenu.CircleMenu;
import com.imangazaliev.circlemenu.CircleMenuButton;

import java.util.ArrayList;
import java.util.List;

import km.lmy.searchview.SearchView;
public class Main2Activity extends AppCompatActivity {
    Toolbar activityToolbar;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        activityToolbar=(Toolbar)findViewById(R.id.activity_toolbar);
        searchView=(SearchView)findViewById(R.id.searchView);

        activityToolbar.setTitle(this.getTitle());
        activityToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(activityToolbar);

        List<String> historyList = new ArrayList<>();
        historyList.add("Joker");
        historyList.add("Harry");
        historyList.add("Kate");
        historyList.add("Alice");

        //设置全新的历史记录列表
        searchView.setNewHistoryList(historyList);

        //添加一条历史记录
        searchView.addOneHistory("Jenson");

        //设置搜索框默认值
        searchView.setSearchEditText("薛之谦被爆与前女友纠缠不清");
//        尝试一下获取数据
        EditText textView = searchView.getEditTextView();
        Toast.makeText(Main2Activity.this, textView.getText().toString(), Toast.LENGTH_SHORT).show();

        //设置历史记录点击事件
        searchView.setHistoryItemClickListener(new SearchView.OnHistoryItemClickListener() {
            @Override
            public void onClick(String historyStr, int position) {
                Toast.makeText(Main2Activity.this, historyStr, Toast.LENGTH_SHORT).show();
//                显示在默认上面
                searchView.setSearchEditText(historyStr);
            }
        });

        //设置输入文本监听事件
        searchView.setOnInputTextChangeListener(new SearchView.OnInputTextChangeListener() {
            @Override
            public void onTextChanged(CharSequence charSequence) {
                Toast.makeText(Main2Activity.this, "文本改变", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence) {
                Toast.makeText(Main2Activity.this, "改变前", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(Main2Activity.this, "改变后", Toast.LENGTH_SHORT).show();
            }
        });
//        在很酷的按钮里面实现一个按钮
//        final ViewGroup snackbarContainer = (ViewGroup) findViewById(R.id.snackbar_contaner);
        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
            @Override
            public void onItemClick(CircleMenuButton menuButton) {
//                Snackbar.make(snackbarContainer, menuButton.getHintText(), Snackbar.LENGTH_LONG).show();
            }
        });

        circleMenu.setStateUpdateListener(new CircleMenu.OnStateUpdateListener() {
            @Override
            public void onMenuExpanded() {
                Log.d("CircleMenuStatus", "Expanded");
            }

            @Override
            public void onMenuCollapsed() {
                Log.d("CircleMenuStatus", "Collapsed");
            }
        });

    }
    //        加载菜单类似

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);//加载menu文件到布局
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                //自动打开关闭SearchView
                searchView.autoOpenOrClose();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
