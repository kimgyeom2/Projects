package com.gy25m.ex92kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class MainActivity : AppCompatActivity() {

    // 뷰 참조변수는 보통 참조값이 변경되지 않기에 보통 val로 씀
    val recycler:RecyclerView by lazy {findViewById(R.id.recycler)} //처음 사용될때 find됨

    // 대량의 데이터들
    var items:MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 대량의 데이터 추가
        items.add(Item("sam","Hello Kotlin",R.drawable.moana01))
        items.add(Item("robin","welcome android",R.drawable.moana03))
        items.add(Item("hong","Nice ios",R.drawable.moana04))
        items.add(Item("lee","Hello Kotlin",R.drawable.moana01))
        items.add(Item("park","welcome android",R.drawable.moana03))
        items.add(Item("kim","Nice ios",R.drawable.moana04))
        items.add(Item("rosa","Hello Kotlin",R.drawable.moana01))
        items.add(Item("king","welcome android",R.drawable.moana03))
        items.add(Item("kong","Nice ios",R.drawable.moana04))

        // 리사이클러뷰에 아답터를 설정하기
        recycler.adapter=MyAdapter(this,items)

        // 리사이클러뷰에 레이아웃 매니저를 설정
        recycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    override fun onResume() {
        super.onResume()

        // 보통 이곳에서 데이터들을 갱신하는 작업들이 이루어짐
        recycler.adapter?.notifyDataSetChanged()
        //recycler.adapter!!.notifyDataSetChanged() 위에가 더 안전함
    }

    // 옵션메뉴를 만드는 작업을 하는 콜백 메소드
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //meniInflater를 get하는 작업필요 없이 이미 액티비티에 객체로 존재
        menuInflater.inflate(R.menu.option,menu)
        return super.onCreateOptionsMenu(menu)
    }

    // 옵션메뉴 아이템을 선택하면 자동으로 발동하는 콜백메소드
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_aa-> Toast.makeText(this, "aa", Toast.LENGTH_SHORT).show()
            R.id.menu_bb-> {
                Toast.makeText(this, "bb", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
