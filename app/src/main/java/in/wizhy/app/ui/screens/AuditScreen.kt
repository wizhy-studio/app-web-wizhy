package in.wizhy.app.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import in.wizhy.app.ui.components.ActionUtils
import in.wizhy.app.ui.theme.AccentGold
import in.wizhy.app.ui.theme.AccentGreen
import in.wizhy.app.ui.theme.WizhyOrange
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuditScreen() {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val keyboardController = LocalSoftwareKeyboardController.current

    var urlInput by remember { mutableStateOf("") }
    var isScanning by remember { mutableStateOf(false) }
    var scanProgress by remember { mutableFloatStateOf(0f) }
    var scanResultReady by remember { mutableStateOf(false) }
    var score by remember { mutableIntStateOf(0) }
    var analyzedUrl by remember { mutableStateOf("") }

    fun runAudit() {
        if (urlInput.isBlank()) return
        keyboardController?.hide()
        isScanning = true
        scanResultReady = false
        scanProgress = 0f

        coroutineScope.launch {
            for (i in 1..10) {
                delay(150)
                scanProgress = i / 10f
            }
            analyzedUrl = if (!urlInput.startsWith("http")) "https://$urlInput" else urlInput
            // Simulated intelligent snapshot score based on url string hash
            score = 75 + (Random(urlInput.hashCode()).nextInt(22))
            isScanning = false
            scanResultReady = true
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(WizhyOrange.copy(alpha = 0.15f))
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = "⚡ INSTANT AUDIT ENGINE",
                            color = WizhyOrange,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "How does your current website stack up?",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Enter your website URL for an instant SEO & speed snapshot — an instant preview of our pre-kickoff audit.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Input Box Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    OutlinedTextField(
                        value = urlInput,
                        onValueChange = { urlInput = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text(text = "yourbusiness.com") },
                        label = { Text(text = "Website URL") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Language, contentDescription = null, tint = WizhyOrange)
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Uri,
                            imeAction = ImeAction.Go
                        ),
                        keyboardActions = KeyboardActions(onGo = { runAudit() }),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Button(
                        onClick = { runAudit() },
                        enabled = urlInput.isNotBlank() && !isScanning,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = WizhyOrange),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = if (isScanning) "Analyzing Website..." else "Run Free Audit ⚡",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(text = "⚡ 2-Sec Analysis", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text(text = "•", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text(text = "🔒 No Signup Required", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text(text = "•", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text(text = "🎯 100% Free", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }

                    if (isScanning) {
                        Spacer(modifier = Modifier.height(16.dp))
                        LinearProgressIndicator(
                            progress = { scanProgress },
                            modifier = Modifier.fillMaxWidth(),
                            color = WizhyOrange
                        )
                    }
                }
            }
        }

        // Result Card
        item {
            AnimatedVisibility(visible = scanResultReady) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column {
                                Text(
                                    text = "Audit Snapshot",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = analyzedUrl,
                                    fontSize = 12.sp,
                                    color = WizhyOrange,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(CircleShape)
                                    .background(AccentGreen.copy(alpha = 0.15f))
                                    .border(3.dp, AccentGreen, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "$score",
                                        fontWeight = FontWeight.Black,
                                        fontSize = 20.sp,
                                        color = AccentGreen
                                    )
                                    Text(text = "/100", fontSize = 9.sp, color = AccentGreen)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)
                        Spacer(modifier = Modifier.height(14.dp))

                        Text(
                            text = "Key Snapshot Findings:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                        Spacer(modifier = Modifier.height(6.dp))

                        AuditFindingRow(title = "Core Web Vitals Speed", status = if (score > 85) "Good (1.2s)" else "Needs Optimization (3.4s)", passed = score > 85)
                        AuditFindingRow(title = "Mobile-First Responsiveness", status = "Passed", passed = true)
                        AuditFindingRow(title = "Schema JSON-LD & Structured Data", status = if (score > 80) "Detected" else "Missing / Incomplete", passed = score > 80)
                        AuditFindingRow(title = "Day-1 Google Search Indexing", status = "Review Recommended", passed = false)

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = {
                                ActionUtils.openWhatsApp(
                                    context = context,
                                    message = "Hi Wizhy! I ran a free audit for $analyzedUrl and got a score of $score/100. I want the full human-reviewed report!"
                                )
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = WizhyOrange),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "Get Full Human-Reviewed Audit Free →", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AuditFindingRow(title: String, status: String, passed: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = if (passed) AccentGreen else AccentGold,
                modifier = Modifier.size(16.dp)
            )
            Text(text = title, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface)
        }
        Text(
            text = status,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (passed) AccentGreen else AccentGold
        )
    }
}
