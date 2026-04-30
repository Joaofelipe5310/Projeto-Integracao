#define MyAppName "Projeto_Integracao-1.0"
#define MyAppVersion "3.0"
#define MyAppPublisher "Felipe"
#define MyAppURL "http://www.example.com/"
#define MyAppJarName "Projeto_Integracao-1.0-jfx.jar"
#define MyAppExeName "Projeto_Integracao-1.0.exe"

[Setup]
AppId={{968A9508-48D4-47E6-A820-485285A1B42B}}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
DefaultDirName={localappdata}\{#MyAppName}
DisableProgramGroupPage=yes
PrivilegesRequired=lowest
OutputBaseFilename=Projeto_Integracao-1.0
SetupIconFile=Projeto_Integracao-1.0/Projeto_Integracao-1.0.ico
WizardSmallImageFile=Projeto_Integracao-1.0-setup-icon.bmp
UninstallDisplayIcon={app}/Projeto_Integracao-1.0.ico
UninstallDisplayName=uninstalller
WizardImageStretch=yes
Compression=lzma
SolidCompression=yes
AlwaysShowDirOnReadyPage=yes
CreateAppDir=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; \
GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "Projeto_Integracao-1.0\Projeto_Integracao-1.0.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "Projeto_Integracao-1.0\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\{#MyAppName}";                     \
Filename: "{app}\{#MyAppExeName}";                \
IconFilename: "{app}\Projeto_Integracao-1.0.ico"; \
WorkingDir: "{app}"

Name: "{commondesktop}\{#MyAppName}";             \
Filename: "{app}\{#MyAppExeName}";                \
WorkingDir: "{app}";                              \
IconFilename: "{app}\Projeto_Integracao-1.0.ico"; \
Tasks: desktopicon

[Run]
Filename: "{app}\{#MyAppExeName}";                \
Description:"{cm:LaunchProgram,{#MyAppName}}";    \
Flags: nowait postinstall skipifsilent;

[UninstallRun]
Filename: "{app}\uninstaller";                    \
Parameters: "-uninstall -svcName {#MyAppName} -stopOnUninstall";