package com.datnx.my_design_system

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.datnx.design_system.components.ButtonApp
import com.datnx.my_design_system.ui.theme.MyDesignSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDesignSystemTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ButtonSampleScreen()
                }
            }
        }
    }
}



@Composable
fun ButtonSampleScreen() {
    val context = LocalContext.current
    var clickCounter by remember { mutableIntStateOf(0) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header
        Text(
            text = "My Design System Demo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Button Examples Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "ButtonApp Examples",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                
                // Standard enabled button
                ButtonApp(
                    modifier = Modifier.fillMaxWidth(),
                    btnTitle = "Primary Button",
                    isEnable = true,
                    onBtnClick = {
                        clickCounter++
                        Toast.makeText(context, "Primary button clicked! Count: $clickCounter", Toast.LENGTH_SHORT).show()
                    }
                )
                
                // Disabled button
                ButtonApp(
                    modifier = Modifier.fillMaxWidth(),
                    btnTitle = "Disabled Button",
                    isEnable = false,
                    onBtnClick = {
                        Toast.makeText(context, "This button is disabled", Toast.LENGTH_SHORT).show()
                    }
                )
                
                // Action button with different text
                ButtonApp(
                    btnTitle = "Save Changes",
                    isEnable = true,
                    onBtnClick = {
                        Toast.makeText(context, "Changes saved successfully!", Toast.LENGTH_SHORT).show()
                    }
                )
                
                // Small button
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    ButtonApp(
                        btnTitle = "Small Action",
                        isEnable = true,
                        onBtnClick = {
                            Toast.makeText(context, "Small action performed", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
        
        // Information Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F9FA))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Button Features:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                val features = listOf(
                    "• Custom rounded corners (8dp top-left, top-right, bottom-right)",
                    "• Dynamic colors based on enabled state",
                    "• Custom typography from design system",
                    "• Consistent padding and styling",
                    "• Click counter: $clickCounter"
                )
                
                features.forEach { feature ->
                    Text(
                        text = feature,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )
                }
            }
        }
        
        // Color Demo Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Interactive Demo",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                
                Text(
                    text = "Try clicking the buttons above to see the toast messages and watch the click counter!",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                
                ButtonApp(
                    modifier = Modifier.fillMaxWidth(),
                    btnTitle = "Reset Counter",
                    isEnable = clickCounter > 0,
                    onBtnClick = {
                        clickCounter = 0
                        Toast.makeText(context, "Counter reset!", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonSampleScreenPreview() {
    MyDesignSystemTheme {
        ButtonSampleScreen()
    }
}