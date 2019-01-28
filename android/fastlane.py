import subprocess

out = subprocess.check_output(['fastlane', 'google_play_check_version_code_internal'])
out = out.decode('utf-8')

lines = out.splitlines()

i = 0
vline = ''
while i < len(lines):
    line = lines[i]

    if 'version codes in track' in line:
        vline = line
        break

    i += 1

words = vline.split()
i = 0
vc = ''
while i < len(words):
    word = words[i]

    if 'version' == word:
        vc = words[i-1][1:-1]
        print('Version code of APK in Google Play: ' + vc)
        break

    i += 1

out_git = subprocess.check_output(['git', 'rev-list', 'HEAD', '--first-parent', '--count'])
out_git = out_git.decode('utf-8')
print('Version code of source code in git server: ' + out_git)

if int(vc) < int(out_git):
    out_upload = subprocess.run(['fastlane', 'google_play_internal'])
else:
    print('Source code is not newer than APK. Do nothing!')
