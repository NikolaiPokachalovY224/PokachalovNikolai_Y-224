import json
def filej():
    n=nm.get()
    f_json="""
    {
        'company': 'MOGU'
        'created_at': '2015-12-07T09:32:18Z'
        'email': None
        'id': 16187777
        'name': 'Ori'
        'url': 'https://api.github.com/users/origin'
    }"""
    if n=='origin':
            with open('F:\\PyPr\\11\\vivod.json','w') as file:
                json.dump(f_json,file)
import tkinter as tk
win=tk.Tk()
win.geometry('200x100')
win.title("json")
nm=tk.Entry(win)
nm.grid(padx=40,pady=20)
butn=tk.Button(win,text="ОК",command=filej)
butn.grid(padx=30,pady=0)
win.mainloop()
filej()