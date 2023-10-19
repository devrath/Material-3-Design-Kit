package com.istudio.materialapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.istudio.materialapp.modules.ui_components.ui_alertdialog.AlertDialogActivity
import com.istudio.materialapp.modules.ui_components.ui_bottomSheets.MaterialBottomSheetActivity
import com.istudio.materialapp.modules.ui_components.ui_bottomappbar.BottomAppBarActivity
import com.istudio.materialapp.modules.ui_components.ui_bottomnavbar.activity.BottomNavigationBarActivity
import com.istudio.materialapp.modules.ui_components.ui_buttons.ButtonsActivity
import com.istudio.materialapp.modules.ui_components.ui_exposeddropdown.ExposedDropDownActivity
import com.istudio.materialapp.modules.ui_components.ui_navigationdrawer.NavigationDrawerActivity
import com.istudio.materialapp.modules.ui_components.ui_selectioncomponents.SelectionComponentsActivity
import com.istudio.materialapp.modules.ui_components.ui_swipabletabrows.SwipableTabRowsActivity
import com.istudio.materialapp.modules.ui_components.ui_textfields.TextFieldsActivity
import com.istudio.materialapp.modules.ui_components.ui_toolbar.MaterialToolbarActivity
import com.istudio.materialapp.ui.theme.MaterialAppTheme
import com.istudio.materialapp.utils.startActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CurrentScreen("Android")
                }
            }
        }
    }
}

@Composable
fun CurrentScreen(name: String) {
    val cxt = LocalContext.current
    val spacerHeight = 5.dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { cxt.startActivity<AlertDialogActivity>() }
        ) { Text(text = "Material Alert Dialog") }

        Spacer(modifier = Modifier.height(spacerHeight))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { cxt.startActivity<BottomAppBarActivity>() }
        ) { Text(text = "Material Bottom App Bar") }

        Spacer(modifier = Modifier.height(spacerHeight))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { cxt.startActivity<BottomNavigationBarActivity>() }
        ) { Text(text = "Material Bottom Navigation Bar") }

        Spacer(modifier = Modifier.height(spacerHeight))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { cxt.startActivity<MaterialBottomSheetActivity>() }
        ) { Text(text = "Material Bottom Sheet") }

        Spacer(modifier = Modifier.height(spacerHeight))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { cxt.startActivity<ButtonsActivity>() }
        ) { Text(text = "Material buttons") }

        Spacer(modifier = Modifier.height(spacerHeight))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { cxt.startActivity<ExposedDropDownActivity>() }
        ) { Text(text = "Exposed Drop Down") }

        Spacer(modifier = Modifier.height(spacerHeight))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { cxt.startActivity<NavigationDrawerActivity>() }
        ) { Text(text = "Material navigation Drawer") }

        Spacer(modifier = Modifier.height(spacerHeight))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { cxt.startActivity<SelectionComponentsActivity>() }
        ) { Text(text = "Material Selection Components") }

        Spacer(modifier = Modifier.height(spacerHeight))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { cxt.startActivity<SwipableTabRowsActivity>() }
        ) { Text(text = "Material Swipable Tabs") }

        Spacer(modifier = Modifier.height(spacerHeight))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { cxt.startActivity<TextFieldsActivity>() }
        ) { Text(text = "Material Text Fields") }

        Spacer(modifier = Modifier.height(spacerHeight))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { cxt.startActivity<MaterialToolbarActivity>() }
        ) { Text(text = "Material Toolbar") }
    }
}





@Preview(showBackground = true)
@Composable
private fun CurrentScreenPreview() {
    MaterialAppTheme {
        CurrentScreen("Android")
    }
}