<h3>1.  SharedPreferences usage </h3>
 ```java
    public void showProp(View view){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        increasePropValue(sharedPref);
        EditText textField = (EditText) findViewById(R.id.editText);
        textField.setText(String.valueOf(sharedPref.getInt("score", 1)));
    }

    private void increasePropValue(SharedPreferences sharedPref){
        int highScore = sharedPref.getInt("score", 1);
        SharedPreferences.Editor editor = sharedPref.edit();
        highScore = highScore + 1;
        editor.putInt("score", highScore);
        editor.commit();
    }
  ```
