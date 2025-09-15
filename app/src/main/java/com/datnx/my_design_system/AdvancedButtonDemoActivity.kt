package com.datnx.my_design_system

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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

/**
 * Advanced demo activity showing different button layouts and scenarios
 */
class AdvancedButtonDemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDesignSystemTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AdvancedButtonDemoScreen()
                }
            }
        }
    }
}

@Composable
fun AdvancedButtonDemoScreen() {
    val context = LocalContext.current
    var formState by remember { mutableStateOf(FormState()) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        
        // Header
        Text(
            text = "Advanced ButtonApp Demo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        
        // Form-like Demo
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Form Actions",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                
                // Action buttons in a row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ButtonApp(
                        modifier = Modifier.weight(1f),
                        btnTitle = "Save",
                        isEnable = formState.hasChanges,
                        onBtnClick = {
                            formState = formState.copy(isSaved = true, hasChanges = false)
                            Toast.makeText(context, "Form saved!", Toast.LENGTH_SHORT).show()
                        }
                    )
                    
                    ButtonApp(
                        modifier = Modifier.weight(1f),
                        btnTitle = "Cancel",
                        isEnable = formState.hasChanges,
                        onBtnClick = {
                            formState = formState.copy(hasChanges = false, isSaved = false)
                            Toast.makeText(context, "Changes cancelled", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
                
                // Single full-width action
                ButtonApp(
                    modifier = Modifier.fillMaxWidth(),
                    btnTitle = "Submit Form",
                    isEnable = formState.isSaved,
                    onBtnClick = {
                        formState = formState.copy(isSubmitted = true)
                        Toast.makeText(context, "Form submitted successfully!", Toast.LENGTH_LONG).show()
                    }
                )
                
                // Form state info
                Text(
                    text = "Form State: ${if (formState.isSubmitted) "Submitted" else if (formState.isSaved) "Saved" else if (formState.hasChanges) "Has Changes" else "No Changes"}",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
        
        // Multiple Button Sizes Demo
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Different Button Layouts",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                
                // Three buttons in a row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    ButtonApp(
                        modifier = Modifier.weight(1f),
                        btnTitle = "Yes",
                        onBtnClick = { 
                            Toast.makeText(context, "Yes selected", Toast.LENGTH_SHORT).show() 
                        }
                    )
                    ButtonApp(
                        modifier = Modifier.weight(1f),
                        btnTitle = "No",
                        onBtnClick = { 
                            Toast.makeText(context, "No selected", Toast.LENGTH_SHORT).show() 
                        }
                    )
                    ButtonApp(
                        modifier = Modifier.weight(1f),
                        btnTitle = "Maybe",
                        onBtnClick = { 
                            Toast.makeText(context, "Maybe selected", Toast.LENGTH_SHORT).show() 
                        }
                    )
                }
                
                // Centered small buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    ButtonApp(
                        btnTitle = "Edit",
                        onBtnClick = { 
                            formState = formState.copy(hasChanges = true)
                            Toast.makeText(context, "Edit mode enabled", Toast.LENGTH_SHORT).show() 
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    ButtonApp(
                        btnTitle = "Delete",
                        isEnable = !formState.isSubmitted,
                        onBtnClick = { 
                            formState = FormState()
                            Toast.makeText(context, "Deleted!", Toast.LENGTH_SHORT).show() 
                        }
                    )
                }
            }
        }
        
        // State Management Demo
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "State-dependent Buttons",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                
                ButtonApp(
                    modifier = Modifier.fillMaxWidth(),
                    btnTitle = "Start Process",
                    isEnable = !formState.isProcessing,
                    onBtnClick = {
                        formState = formState.copy(isProcessing = true)
                        Toast.makeText(context, "Process started...", Toast.LENGTH_SHORT).show()
                        // Simulate process completion after a delay
                        // In real app, this would be handled by a coroutine or callback
                    }
                )
                
                ButtonApp(
                    modifier = Modifier.fillMaxWidth(),
                    btnTitle = if (formState.isProcessing) "Processing..." else "Process Complete",
                    isEnable = !formState.isProcessing,
                    onBtnClick = {
                        if (!formState.isProcessing) {
                            Toast.makeText(context, "Process was already complete", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
                
                ButtonApp(
                    modifier = Modifier.fillMaxWidth(),
                    btnTitle = "Reset All",
                    onBtnClick = {
                        formState = FormState()
                        Toast.makeText(context, "Everything reset!", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}

data class FormState(
    val hasChanges: Boolean = false,
    val isSaved: Boolean = false,
    val isSubmitted: Boolean = false,
    val isProcessing: Boolean = false
)

@Preview(showBackground = true)
@Composable
fun AdvancedButtonDemoScreenPreview() {
    MyDesignSystemTheme {
        AdvancedButtonDemoScreen()
    }
}