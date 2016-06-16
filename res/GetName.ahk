Array := Object()
WinGetTitle, Title, A
ArrayCount := 0                        
Loop, Read, %A_ScriptDir%\unapproved.txt
{
	ArrayCount += 1
	Array[ArrayCount] := A_LoopReadLine
}
 Loop %ArrayCount%
 {
	element := Array[A_Index]
	returnValue := inStr(Title, Array[A_Index])
	if(returnValue > 0)
		ExitApp 1
}

Loop, Read, %A_ScriptDir%\tentative.txt
{
	ArrayCount += 1
	Array[ArrayCount] := A_LoopReadLine
}
 Loop %ArrayCount%
 {
	element := Array[A_Index]
	returnValue := inStr(Title, Array[A_Index])
	if(returnValue > 0)
		ExitApp 2
}

Loop, Read, %A_ScriptDir%\approved.txt
{
	ArrayCount += 1
	Array[ArrayCount] := A_LoopReadLine
}
 Loop %ArrayCount%
 {
	element := Array[A_Index]
	returnValue := inStr(Title, Array[A_Index])
	if(returnValue > 0)
		ExitApp 3
}

ExitApp 0