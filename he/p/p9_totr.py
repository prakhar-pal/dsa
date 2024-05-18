#/usr/bin/python3
#https://www.codechef.com/problems/TOTR

from string import ascii_lowercase
# def translate(mapping, sentence):
#     for idx in range(len(sentence)):
if __name__ == "__main__":
    t,d = input().split(" ")
    t = int(t)
    out = []
    diction = {}
    for i in range(len(d)):
        diction[ascii_lowercase[i]] = d[i]
    # pr/int(diction)
    for i in range(t):
        sentence = input()
        translated_sentence = ""
        for index in range(len(sentence)):
            ch = sentence[index].lower()
            tch = diction[ch] if ch in diction else sentence[index]
            if ch != sentence[index]:
                tch = tch.upper()
            if tch == "_":
                tch = " "
            translated_sentence = translated_sentence + tch
        out.append(translated_sentence)
    for i in range(t):
        print(out[i])
