import pandas as pd
import numpy as np
file_name='WBA In-person Survey (1)'
df = pd.read_csv(f"Downloads/{file_name}.csv")
df = df[df['Q1.6']=='This is a self-assessment']
mask = (df['Status'] == 1) | (df['Status'] == '1')
df = df.drop(df[mask].index)
print(df['Q1.5'].value_counts())
