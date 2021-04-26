
public class MainActivity3 extends AppCompatActivity {


    private RadioGroup rg;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private BlankFragment1 fragment1;
    private BlankFragment2 fragment2;
    private BlankFragment3 fragment3;
    private BlankFragment4 fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        fragment1 = new BlankFragment1();
        fragment2 = new BlankFragment2();
        fragment3 = new BlankFragment3();
        fragment4 = new BlankFragment4();


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl, fragment1).commit();
//        fragmentTransaction
//                .add(R.id.fl, fragment1)
//                .add(R.id.fl, fragment2).hide(fragment2)
//                .add(R.id.fl, fragment3).hide(fragment3)
//                .add(R.id.fl, fragment4).hide(fragment4)
//                .show(fragment1)
//                .commit();


        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                fragmentTransaction = fragmentManager.beginTransaction();
//                switch (checkedId) {
//                    case R.id.rb1:
//                        fragmentTransaction.show(fragment1).hide(fragment2).hide(fragment3).hide(fragment4);
//                        break;
//                    case R.id.rb2:
//                        fragmentTransaction.hide(fragment1).show(fragment2).hide(fragment3).hide(fragment4);
//                        break;
//                    case R.id.rb3:
//                        fragmentTransaction.hide(fragment1).hide(fragment2).show(fragment3).hide(fragment4);
//                        break;
//                    case R.id.rb4:
//                        fragmentTransaction.hide(fragment1).hide(fragment2).hide(fragment3).show(fragment4);
//                        break;
//                }
//                fragmentTransaction.commit();

                switch (checkedId) {
                    case R.id.rb1:
                        fragmentTransaction.replace(R.id.fl, new BlankFragment1());
                        break;
                    case R.id.rb2:
                        fragmentTransaction.replace(R.id.fl, new BlankFragment2());
                        break;
                    case R.id.rb3:
                        fragmentTransaction.replace(R.id.fl, new BlankFragment3());
                        break;
                    case R.id.rb4:
                        fragmentTransaction.replace(R.id.fl, new BlankFragment4());
                        break;
                }
                fragmentTransaction.commit();
            }
        });

    }

}
FragmentManager 
FragmentTransaction
replace()


Fragment1  onAttach
Fragment1  onCreate
Fragment1  onCreateView
Fragment1  onStart
Fragment1  onResume
Fragment1  onPause
Fragment1  onStop
Fragment1  onDestroyView
Fragment1  onDestroy
Fragment1  onDetach

onHiddenChanged  不会执行
setUserVisibleHint 不会执行

fragmentTransaction.replace(R.id.fl, new BlankFragment1()); 
fragmentTransaction.replace(R.id.fl, fragment1);
无差别
从当前fragment打开新的页面时，正常onPause-->onStop
从新的页面返回当前fragment,onStart-->onResume


-----------------------------------------------------------------


只使用add 
Fragment1  onAttach
Fragment1  onCreate
Fragment1  onCreateView
Fragment1  onStart
Fragment1  onResume
Fragment1  onAttach
Fragment1  onCreate
Fragment1  onCreateView
Fragment1  onStart
Fragment1  onResume

-------------------------------------------------------------------------
使用 add  show hide
onHiddenChanged 会被调用  
切换tab 时 onHiddenChanged会被调用

从当前fragment打开新的页面时，正常onPause-->onStop
从新的页面返回当前fragment,onStart-->onResume

打印声明周期
Fragment1  onAttach
Fragment1  onCreate
Fragment1  onCreateView
Fragment1  onStart
Fragment1  onResume
Fragment1  onHiddenChanged
Fragment1  onHiddenChanged
Fragment1  onHiddenChanged
Fragment1  onHiddenChanged

public class MainActivity3 extends AppCompatActivity {


    private RadioGroup rg;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private BlankFragment1 fragment1;
    private BlankFragment2 fragment2;
    private BlankFragment3 fragment3;
    private BlankFragment4 fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        fragment1 = new BlankFragment1();
        fragment2 = new BlankFragment2();
        fragment3 = new BlankFragment3();
        fragment4 = new BlankFragment4();


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fl, new BlankFragment1()).commit();
        fragmentTransaction
                .add(R.id.fl, fragment1)
                .add(R.id.fl, fragment2).hide(fragment2)
                .add(R.id.fl, fragment3).hide(fragment3)
                .add(R.id.fl, fragment4).hide(fragment4)
                .show(fragment1)
                .commit();


        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                fragmentTransaction = fragmentManager.beginTransaction();
                switch (checkedId) {
                    case R.id.rb1:
                        fragmentTransaction.show(fragment1).hide(fragment2).hide(fragment3).hide(fragment4);
                        break;
                    case R.id.rb2:
                        fragmentTransaction.hide(fragment1).show(fragment2).hide(fragment3).hide(fragment4);
                        break;
                    case R.id.rb3:
                        fragmentTransaction.hide(fragment1).hide(fragment2).show(fragment3).hide(fragment4);
                        break;
                    case R.id.rb4:
                        fragmentTransaction.hide(fragment1).hide(fragment2).hide(fragment3).show(fragment4);
                        break;
                }
                fragmentTransaction.commit();
            }
        });
    }
}


-----------------------
FragmentPagerAdapter

public class MainActivity4 extends AppCompatActivity {


    RadioGroup rg;
    RadioButton rb1, rb2, rb3, rb4;
    ArrayList<Fragment> fragments;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        vp=findViewById(R.id.vp);
        rg=findViewById(R.id.rg);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        rb4=findViewById(R.id.rb4);

        fragments=new ArrayList<>();
        fragments.add(new BlankFragment1());
        fragments.add(new BlankFragment2());
        fragments.add(new BlankFragment3());
        fragments.add(new BlankFragment4());

        Adapter1 adapter1=new Adapter1(getSupportFragmentManager(),fragments);
        vp.setAdapter(adapter1);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        vp.setCurrentItem(0,false);
                        fragments.get(1).onResume();
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1,false);
                        break;
                    case R.id.rb3:
                        vp.setCurrentItem(2,false);
                        break;
                    case R.id.rb4:
                        vp.setCurrentItem(3,false);
                        break;
                }
            }
        });
    }
}

viewPager切换item，会调用setUserVisibleHint， setUserVisibleHint==true的时候，view可能还没好
判断viewCreate onResume

ViewPager的缓存策略，默认缓存3个，只有销毁之后，fragment数据才会刷新
FragmentPagerAdapter中的onDestroy方法的调用和缓存一致，超出缓存，才会被调用

FragmentPagerAdapter


FragmentPagerAdapter 继承自 PagerAdapter。相比通用的 PagerAdapter，该类更专注于每一页均为 Fragment 的情况。如文档所述， 该类内的每一个生成的 Fragment 都将保存在内存之中，因此适用于那些相对静态的页，数量也比较少的那种；如果需要处理有很多页，并且数据动态性较大、占用内存较多的情况，应该使用 FragmentStatePagerAdapter。FragmentPagerAdapter 重载实现了几个必须的函数，因此来自 PagerAdapter 的函数，我们只需要实现 getCount()，即可。且，由于 FragmentPagerAdapter.instantiateItem() 的实现中，调用了一个新增的虚函数 getItem()，因此，我们还至少需要实现一个 getItem()。因此，总体上来说，相对于继承自 PagerAdapter，更方便一些。
getItem()
该类中新增的一个虚函数。函数的目的为生成新的 Fragment 对象。重载该函数时需要注意这一点。在需要时，该函数将被 instantiateItem() 所调用。
如果需要向 Fragment 对象传递相对静态的数据时，我们一般通过 Fragment.setArguments() 来进行，这部分代码应当放到 getItem()。它们只会在新生成 Fragment 对象时执行一遍。
如果需要在生成 Fragment 对象后，将数据集里面一些动态的数据传递给该 Fragment，那么，这部分代码不适合放到 getItem() 中。因为当数据集发生变化时，往往对应的 Fragment 已经生成，如果传递数据部分代码放到了 getItem() 中，这部分代码将不会被调用。这也是为什么很多人发现调用 PagerAdapter.notifyDataSetChanged() 后，getItem() 没有被调用的一个原因。
instantiateItem()
函数中判断一下要生成的 Fragment 是否已经生成过了，如果生成过了，就使用旧的，旧的将被 Fragment.attach()；如果没有，就调用 getItem() 生成一个新的，新的对象将被 FragmentTransation.add()。
FragmentPagerAdapter 会将所有生成的 Fragment 对象通过 FragmentManager 保存起来备用，以后需要该 Fragment 时，都会从 FragmentManager 读取，而不会再次调用 getItem() 方法。
如果需要在生成 Fragment 对象后，将数据集中的一些数据传递给该 Fragment，这部分代码应该放到这个函数的重载里。在我们继承的子类中，重载该函数，并调用 FragmentPagerAdapter.instantiateItem() 取得该函数返回 Fragment 对象，然后，我们该 Fragment 对象中对应的方法，将数据传递过去，然后返回该对象。
否则，如果将这部分传递数据的代码放到 getItem()中，在 PagerAdapter.notifyDataSetChanged() 后，这部分数据设置代码将不会被调用。
destroyItem()
该函数被调用后，会对 Fragment 进行 FragmentTransaction.detach()。这里不是 remove()，只是 detach()，因此 Fragment 还在 FragmentManager 管理中，Fragment 所占用的资源不会被释放。
FragmentStatePagerAdapter


FragmentStatePagerAdapter 和前面的 FragmentPagerAdapter 一样，是继承子 PagerAdapter。但是，和 FragmentPagerAdapter 不一样的是，正如其类名中的 'State' 所表明的含义一样，该 PagerAdapter 的实现将只保留当前页面，当页面离开视线后，就会被消除，释放其资源；而在页面需要显示时，生成新的页面(就像 ListView 的实现一样)。这么实现的好处就是当拥有大量的页面时，不必在内存中占用大量的内存。
getItem()
一个该类中新增的虚函数。
函数的目的为生成新的 Fragment 对象。
Fragment.setArguments() 这种只会在新建 Fragment 时执行一次的参数传递代码，可以放在这里。
由于 FragmentStatePagerAdapter.instantiateItem() 在大多数情况下，都将调用 getItem() 来生成新的对象，因此如果在该函数中放置与数据集相关的 setter 代码，基本上都可以在 instantiateItem() 被调用时执行，但这和设计意图不符。毕竟还有部分可能是不会调用 getItem() 的。因此这部分代码应该放到 instantiateItem() 中。
instantiateItem()
除非碰到 FragmentManager 刚好从 SavedState 中恢复了对应的 Fragment 的情况外，该函数将会调用 getItem() 函数，生成新的 Fragment 对象。新的对象将被 FragmentTransaction.add()。
FragmentStatePagerAdapter 就是通过这种方式，每次都创建一个新的 Fragment，而在不用后就立刻释放其资源，来达到节省内存占用的目的的。
destroyItem()
将 Fragment 移除，即调用 FragmentTransaction.remove()，并释放其资源。

https://blog.csdn.net/cike110120/article/details/24362201



public class MainActivity5 extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        bottomNavigationView = findViewById(R.id.bottom);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.content);
        Log.e("Coller",(navHostFragment==null)+"");
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}

//    Fragment1  onAttach
//    Fragment1  onCreate
//    Fragment1  onCreateView
//    Fragment1  onStart
//    Fragment1  onResume
//    Fragment1  onPause
//    Fragment1  onStop
//    Fragment1  onDestroyView

切换其他 -->onDestroyView-->再次切换回来--> onDestroy-->onDetach-->onAttach-->onCreate-->onCreateView-->..
//    Fragment1  onDestroy
//    Fragment1  onDetach
//    Fragment1  onAttach
//    Fragment1  onCreate
//    Fragment1  onCreateView
//    Fragment1  onStart
//    Fragment1  onResume



//menu

选项menu 上下文menu 弹出式menu

