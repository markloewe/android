package com.example.ohm;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private TextView tv;
	private Button bt;
	private Spinner sp01;
	private Spinner sp02;
	private Spinner sp03;
	private Spinner sp04;
	private Spinner sp05;

	private String ring1;
	private String ring2;
	private String ring3;
	private String ring4;
	private String ring5;

	private MyAdapter_Universal mMyAdapterUniversal;
	private MyAdapter_Special mMyAdapterSpecial;

	private MyOnItemSelectedListener ringListener1;
	private MyOnItemSelectedListener ringListener2;
	private MyOnItemSelectedListener ringListener3;
	private MyOnItemSelectedListener ringListener4;
	private MyOnItemSelectedListener ringListener5;

	private static final int[] colors_Universal = { R.color.black,
			R.color.brown, R.color.red, R.color.orange, R.color.yellow,
			R.color.green, R.color.blue, R.color.violet, R.color.grey,
			R.color.white, R.color.gold, R.color.silver, R.color.plain };
	private static final int[] string_Universal = { R.string.black,
			R.string.brown, R.string.red, R.string.orange, R.string.yellow,
			R.string.green, R.string.blue, R.string.violet, R.string.grey,
			R.string.white, R.string.gold, R.string.silver, R.string.plain };

	private static final int[] colors_Special = { R.color.black, R.color.black,
			R.color.brown, R.color.red, R.color.orange, R.color.yellow,
			R.color.green, R.color.blue, R.color.violet, R.color.grey,
			R.color.white, R.color.gold, R.color.silver, R.color.plain };
	private static final int[] string_Special = { R.string.nothing,
			R.string.black, R.string.brown, R.string.red, R.string.orange,
			R.string.yellow, R.string.green, R.string.blue, R.string.violet,
			R.string.grey, R.string.white, R.string.gold, R.string.silver,
			R.string.plain };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.butter01:
			tv.setText(allOhm(ring1, ring2, ring3, ring4, ring5));
			break;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			MainActivity.this.finish();
			break;
		}
		return false;
	}

	private void setupView() {
		mMyAdapterUniversal = new MyAdapter_Universal();
		mMyAdapterSpecial = new MyAdapter_Special();
		ringListener1 = new MyOnItemSelectedListener(1);
		ringListener2 = new MyOnItemSelectedListener(2);
		ringListener3 = new MyOnItemSelectedListener(3);
		ringListener4 = new MyOnItemSelectedListener(4);
		ringListener5 = new MyOnItemSelectedListener(5);

		sp01 = (Spinner) findViewById(R.id.spinner01);
		sp01.setAdapter(mMyAdapterUniversal);
		sp01.setOnItemSelectedListener(ringListener1);

		sp02 = (Spinner) findViewById(R.id.spinner02);
		sp02.setAdapter(mMyAdapterUniversal);
		sp02.setOnItemSelectedListener(ringListener2);

		sp03 = (Spinner) findViewById(R.id.spinner03);
		sp03.setAdapter(mMyAdapterUniversal);
		sp03.setOnItemSelectedListener(ringListener3);

		sp04 = (Spinner) findViewById(R.id.spinner04);
		sp04.setAdapter(mMyAdapterUniversal);
		sp04.setOnItemSelectedListener(ringListener4);

		sp05 = (Spinner) findViewById(R.id.spinner05);
		sp05.setAdapter(mMyAdapterSpecial);
		sp05.setOnItemSelectedListener(ringListener5);

		tv = (TextView) findViewById(R.id.textview02);
		bt = (Button) findViewById(R.id.butter01);
		bt.setOnClickListener(this);
	}

	private class MyAdapter_Universal extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 13;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			TextView tv = new TextView(MainActivity.this);
			tv.setText(getResources().getText(string_Universal[position]));
			tv.setTextColor(getResources().getColor(colors_Universal[position]));
			tv.setBackgroundColor(getResources().getColor(
					colors_Universal[position]));
			return tv;
		}

	}

	private class MyAdapter_Special extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 14;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			TextView tv = new TextView(MainActivity.this);
			tv.setText(getResources().getText(string_Special[position]));
			tv.setTextColor(getResources().getColor(colors_Special[position]));
			if (position != 0) {
				tv.setBackgroundColor(getResources().getColor(
						colors_Special[position]));
			}
			return tv;
		}

	}

	private class MyOnItemSelectedListener implements OnItemSelectedListener {

		int i;

		public MyOnItemSelectedListener(int i) {
			this.i = i;
		}

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			switch (i) {
			case 1:
				ring1 = getResources().getString(string_Universal[position]);
				break;
			case 2:
				ring2 = getResources().getString(string_Universal[position]);
				break;
			case 3:
				ring3 = getResources().getString(string_Universal[position]);
				break;
			case 4:
				ring4 = getResources().getString(string_Universal[position]);
				break;
			case 5:
				ring5 = getResources().getString(string_Special[position]);
				break;
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub

		}

	}

	private String allOhm(String ring1, String ring2, String ring3,
			String ring4, String ring5) {
		double ohm = 0;
		String ohm_ = "";
		String unit = "";

		if (numOhm(ring1) == -1 || numOhm(ring2) == -1) {
			ohm = -1;
		} else {
			ohm = numOhm(ring1);
			ohm = ohm * 10 + numOhm(ring2);
		}

		if (ring5.equals("ÎÞ")) {
			if (multplier(ring3) == -1 || "".equals(tolerance(ring4))) {
				ohm = -1;
			} else {
				ohm = ohm * multplier(ring3);
				ohm_ = tolerance(ring4);
			}
		} else {
			if (numOhm(ring3) == -1 || multplier(ring4) == -1
					|| "".equals(tolerance(ring5))) {
				ohm = -1;
			} else {
				ohm = ohm * 10 + numOhm(ring3);
				ohm = ohm * multplier(ring4);
				ohm_ = tolerance(ring5);
			}
		}

		if (ohm > 1000 && ohm <= 1000000) {
			ohm = ohm / 1000;
			unit = "K";
		} else if (ohm > 1000000) {
			ohm = ohm / 1000000;
			unit = "M";
		}

		if (ohm == -1) {
			return "±ð¶ºÎÒºÃÂð£¬±¾´óµõºÜÃ¦ßÕ¡££¨ÄãÊäÈëÖµÔÚÏÖÊµÖÐÎ´³öÏÖ£¬Çë×ÐÏ¸ºË¶ÔºóÔÙ¸æËßÎÒ£¬Ð»Ð»£¡£©";
		} else {
			return String.valueOf(ohm) + unit + ohm_;
		}
	}

	private double numOhm(String whichRing) {
		double ohm = 0;
		if (whichRing.equals("ºÚ")) {
			ohm = 0;
		} else if (whichRing.equals("×Ø")) {
			ohm = 1;
		} else if (whichRing.equals("ºì")) {
			ohm = 2;
		} else if (whichRing.equals("³È")) {
			ohm = 3;
		} else if (whichRing.equals("»Æ")) {
			ohm = 4;
		} else if (whichRing.equals("ÂÌ")) {
			ohm = 5;
		} else if (whichRing.equals("À¶")) {
			ohm = 6;
		} else if (whichRing.equals("×Ï")) {
			ohm = 7;
		} else if (whichRing.equals("»Ò")) {
			ohm = 8;
		} else if (whichRing.equals("°×")) {
			ohm = 9;
		} else if (whichRing.equals("½ð")) {
			ohm = -1;
		} else if (whichRing.equals("Òø")) {
			ohm = -1;
		} else if (whichRing.equals("ÆÓ")) {
			ohm = -1;
		}
		return ohm;
	}

	private double multplier(String whichRing) {
		double ohm = 0;
		if (whichRing.equals("ºÚ")) {
			ohm = 1;
		} else if (whichRing.equals("×Ø")) {
			ohm = 10;
		} else if (whichRing.equals("ºì")) {
			ohm = 100;
		} else if (whichRing.equals("³È")) {
			ohm = 1000;
		} else if (whichRing.equals("»Æ")) {
			ohm = 10000;
		} else if (whichRing.equals("ÂÌ")) {
			ohm = 100000;
		} else if (whichRing.equals("À¶")) {
			ohm = 1000000;
		} else if (whichRing.equals("×Ï")) {
			ohm = 10000000;
		} else if (whichRing.equals("»Ò")) {
			ohm = -1;
		} else if (whichRing.equals("°×")) {
			ohm = -1;
		} else if (whichRing.equals("½ð")) {
			ohm = 0.1;
		} else if (whichRing.equals("Òø")) {
			ohm = 0.01;
		} else if (whichRing.equals("ÆÓ")) {
			ohm = -1;
		}
		return ohm;
	}

	private String tolerance(String whichRing) {
		String ohm_ = "";
		if (whichRing.equals("ºÚ")) {
			ohm_ = "";
		} else if (whichRing.equals("×Ø")) {
			ohm_ = "¡À1%";
		} else if (whichRing.equals("ºì")) {
			ohm_ = "¡À2%";
		} else if (whichRing.equals("³È")) {
			ohm_ = "";
		} else if (whichRing.equals("»Æ")) {
			ohm_ = "";
		} else if (whichRing.equals("ÂÌ")) {
			ohm_ = "¡À0.5%";
		} else if (whichRing.equals("À¶")) {
			ohm_ = "¡À0.25%";
		} else if (whichRing.equals("×Ï")) {
			ohm_ = "¡À0.10%";
		} else if (whichRing.equals("»Ò")) {
			ohm_ = "¡À0.05%";
		} else if (whichRing.equals("°×")) {
			ohm_ = "";
		} else if (whichRing.equals("½ð")) {
			ohm_ = "¡À5%";
		} else if (whichRing.equals("Òø")) {
			ohm_ = "¡À10%";
		} else if (whichRing.equals("ÆÓ")) {
			ohm_ = "¡À20%";
		}
		return ohm_;
	}

}
