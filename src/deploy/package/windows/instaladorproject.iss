#define MyAppName "AGRVAI"
#define MyAppVersion "3.0"
#define MyAppPublisher "Felipe"
#define MyAppURL "http://www.example.com/"
#define MyAppJarName "jfxpl-0.0.1-SNAPSHOT-jfx.jar"

[Setup]
AppId={{968A9508-48D4-47E6-A820-485285A1B42B}}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
DefaultDirName={pf}\{#MyAppName}
DisableProgramGroupPage=yes
OutputDir=Installer 
OutputBaseFilename=setup
SetupIconFile=..\..\..\..\target\jfx\native\jfxpl-0.0.1-SNAPSHOT\favicon.ico
Compression=lzma
SolidCompression=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "..\..\..\..\target\jfx\app\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{commonprograms}\{#MyAppName}"; \
Filename: "javaw.exe"; \
Parameters: "-jar ""{app}\{#MyAppJarName}"""; \
WorkingDir: "{app}"

Name: "{commondesktop}\{#MyAppName}"; \
Filename: "javaw.exe"; \
Parameters: "-jar ""{app}\{#MyAppJarName}"""; \
WorkingDir: "{app}"; \
Tasks: desktopicon

[Run]
Filename: "javaw.exe"; \
Parameters: "-jar ""{app}\{#MyAppJarName}"""; \
WorkingDir: "{app}"; \
Description: "Abrir {#MyAppName}"; \
Flags: nowait postinstall skipifsilent